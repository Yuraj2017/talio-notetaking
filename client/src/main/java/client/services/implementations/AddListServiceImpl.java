package client.services.implementations;

import client.scenes.interfaces.AddListCtrl;
import client.services.interfaces.AddListService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Singleton
public class AddListServiceImpl implements AddListService {
    @FXML
    private TextField listTitle;

    @FXML
    private Label emptyName;

    private final AddListCtrl addListCtrl;

    @Inject
    public AddListServiceImpl(AddListCtrl addListCtrl) {
        this.addListCtrl = addListCtrl;
    }


    public void setEmptyNameText(String text) {
        emptyName.setText(text);
    }

    public String getListTitle() {
        return listTitle.getText();
    }

    public void clearFields() {
        listTitle.clear();
        emptyName.setText("");
    }

    //method that gets called when the ok button is pressed
    public void ok() {
        addListCtrl.ok();
    }

    //method that gets called when the cancel button is pressed
    public void cancel() {
        addListCtrl.cancel();
    }
}
