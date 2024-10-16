package client.scenes.implementations;

import client.scenes.interfaces.JoinedBoardsCtrl;
import client.scenes.interfaces.MainCtrl;
import client.services.interfaces.JoinedBoardsService;
import client.utils.ServerUtils;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import commons.AppClient;
import commons.Board;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

@Singleton
public class JoinedBoardsCtrlImpl implements JoinedBoardsCtrl {

    private final ServerUtils server;
    private final MainCtrl mainCtrl;
    private final JoinedBoardsService service;

    private AppClient client;

    @Inject
    public JoinedBoardsCtrlImpl(ServerUtils server, MainCtrl mainCtrl,
                                JoinedBoardsService service) {
        this.server = server;
        this.mainCtrl = mainCtrl;
        this.service = service;
    }

    public void registerForBoardRename() {
        server.registerForMessages("/topic/renameBoard", Board.class, renamedBoard -> {
            Platform.runLater(() -> {
                if (mainCtrl.getPrimaryStageTitle().equals("Your boards"))
                    updateBoard(renamedBoard);
            });
        });
    }

    public void registerForBoardDeletion() {
        server.registerForMessages("/topic/boardDeletion", Long.class, deletedBoardId -> {
            Platform.runLater(() -> {
                removeBoardById(deletedBoardId);
                if (mainCtrl.getPrimaryStageTitle().equals("Your boards"))
                    service.showJoinedBoards(client.boards.get(server.getServer()));
            });
        });
    }

    public void registerForMessages() {
        registerForBoardRename();
        registerForBoardDeletion();
    }
    public void init() {
        this.client = mainCtrl.getClient();
        service.setJoinByKeyPrompt("Join by key");
        String serverString = server.getServer();
        addServerKeyIntoMap(serverString);
        getBoardsForServer(serverString);
    }

    public void addServerKeyIntoMap(String serverString) {
        if (!client.boards.containsKey(serverString)) {
            ArrayList<Board> boards = new ArrayList<>();
            client.boards.put(serverString, boards);
        }
    }

    public void getBoardsForServer(String serverString) {
        ArrayList<Board> boards = new ArrayList<>();
        if (client.boards.containsKey(serverString)) {
            boards = client.boards.get(serverString);
        }
        service.showJoinedBoards(boards);
    }

    public void showCreateBoard() {
        mainCtrl.showCreateBoard();
    }

    public void leaveBoard(Board board) {
        ArrayList<Board> boards = client.boards.get(server.getServer());
        boards.remove(board);
        client.boards.put(server.getServer(), boards);
        service.showJoinedBoards(boards);
    }

    public void showOptions(Board board) {
        mainCtrl.showBoardOptions(board);
    }

    public void enterBoard(Board board) {
        mainCtrl.showOverview(board.id);
    }

    public void disconnectPressed() {
        mainCtrl.showSelectServer();
        server.stop();
    }

    public void joinByKey() {
        long key = -1;
        try {
            key = Long.parseLong(service.getJoinByKeyText());
        } catch (NumberFormatException e) {
            service.adjustPromptText("Please enter a valid key!");
            return;
        }
        if (!lookForBoardKey(key))
            service.adjustPromptText("No board with that key!");
    }

    public boolean lookForBoardKey(long key) {
        ArrayList<Board> allBoards = (ArrayList<Board>) server.getBoards();
        for (Board board : allBoards)
            if (board.key == key) {
                joinBoard(board);
                service.clearJoinByKey();
                return true;
            }
        return false;
    }

    public void joinBoard(Board board) {
        containsBoardId(board);
        enterBoard(board);
    }

    public void joinPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER)
            joinByKey();
    }

    public boolean containsBoardId(Board newBoard) {
        ArrayList<Board> clientBoards = client.boards.get(server.getServer());
        if(clientBoards == null)
            clientBoards = new ArrayList<>();
        for (Board board : clientBoards)
            if (board.id == newBoard.id)
                return true;
        clientBoards.add(newBoard);
        client.boards.put(server.getServer(), clientBoards);
        return false;
    }

    public void updateBoard(Board board) {
        ArrayList<Board> allBoards = client.boards.get(server.getServer());
        for (int i = 0; i < allBoards.size(); i++)
            if (allBoards.get(i).id == board.id) {
                allBoards.get(i).title = board.title;
                break;
            }
        client.boards.put(server.getServer(), allBoards);
        service.showJoinedBoards(allBoards);
    }

    public void removeBoardById(long boardId) {
        if (client == null)
            client = mainCtrl.getClient();
        ArrayList<Board> allBoards = client.boards.get(server.getServer());
        if (allBoards != null)
            for (int i = 0; i < allBoards.size(); i++)
                if (allBoards.get(i).id == boardId) {
                    allBoards.remove(i);
                    break;
                }
        client.boards.put(server.getServer(), allBoards);
    }

    public void setClient(AppClient client) {
        this.client = client;
    }

    public AppClient getClient() {
        return client;
    }
}
