
package Birthday_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.List;

public class BirthdayController {

    @FXML private TableView<Birthday> table;
    @FXML private TableColumn<Birthday, Integer> colId;
    @FXML private TableColumn<Birthday, String> colName;
    @FXML private TableColumn<Birthday, LocalDate> colDob;
    @FXML private TextField nameField, searchField;
    @FXML private DatePicker dobPicker;
    @FXML private Label labelToday;

    private ObservableList<Birthday> birthdayList;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("dob"));

        refreshTable();
        checkTodayBirthday();

        table.setOnMouseClicked((MouseEvent e) -> {
            Birthday b = table.getSelectionModel().getSelectedItem();
            if (b != null) {
                nameField.setText(b.getName());
                dobPicker.setValue(b.getDob());
            }
        });
    }

    public void refreshTable() {
        List<Birthday> list = BirthdayDAO.getAllBirthdays();
        birthdayList = FXCollections.observableArrayList(list);
        table.setItems(birthdayList);
    }

    public void handleAdd() {
        BirthdayDAO.addBirthday(nameField.getText(), dobPicker.getValue());
        refreshTable();
    }

    public void handleUpdate() {
        Birthday b = table.getSelectionModel().getSelectedItem();
        if (b != null) {
            BirthdayDAO.updateBirthday(b.getId(), nameField.getText(), dobPicker.getValue());
            refreshTable();
        }
    }

    public void handleDelete() {
        Birthday b = table.getSelectionModel().getSelectedItem();
        if (b != null) {
            BirthdayDAO.deleteBirthday(b.getId());
            refreshTable();
        }
    }

    public void handleSearch() {
        String keyword = searchField.getText();
        List<Birthday> list = BirthdayDAO.searchBirthdays(keyword);
        birthdayList = FXCollections.observableArrayList(list);
        table.setItems(birthdayList);
    }

    public void handleShowAll() {
        refreshTable();
    }

    private void checkTodayBirthday() {
        LocalDate today = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        for (Birthday b : BirthdayDAO.getAllBirthdays()) {
            if (b.getDob().getDayOfMonth() == today.getDayOfMonth() &&
                    b.getDob().getMonth() == today.getMonth()) {
                sb.append(b.getName()).append(" ");
            }
        }
        labelToday.setText("🎂 আজকের জন্মদিন: " + (sb.length() > 0 ? sb.toString() : "কেউ নেই"));
    }
}
