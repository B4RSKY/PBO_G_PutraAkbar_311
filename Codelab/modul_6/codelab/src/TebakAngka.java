    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.scene.paint.Color;
    import javafx.stage.Stage;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontWeight;

    import java.util.Random;

    public class TebakAngka extends Application {

        private Random random = new Random();
        private int angkaRahasia;
        private int jumlahPercobaan;

        private Label feedbackLabel;
        private Label percobaanLabel;
        private TextField tebakanField;
        private Button tebakButton;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Game Tebak Angka");

            resetGame();

            // Komponen UI
            Label judulLabel = new Label("Coba Tebak Angka dari 1 - 100!");
            judulLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 17));
            judulLabel.setTextFill(Color.PURPLE);

            tebakanField = new TextField();
            tebakanField.setPromptText("Masukkan tebakan Anda");
            tebakanField.setMaxWidth(150);

            tebakButton = new Button("Coba Tebak!");
            tebakButton.setStyle("-fx-background-color: #2ac60f");
            tebakButton.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
            tebakButton.setTextFill(Color.WHITE);
            tebakButton.setOnAction(e -> prosesTebakan());

            feedbackLabel = new Label("Masukkan angka dan klik 'Coba Tebak!'");

            feedbackLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
            feedbackLabel.setTextFill(Color.PURPLE);

            percobaanLabel = new Label("Percobaan: " + jumlahPercobaan);
            percobaanLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
            percobaanLabel.setTextFill(Color.PURPLE);

            // Layout
            HBox inputArea = new HBox(10, tebakanField, tebakButton);
            inputArea.setAlignment(Pos.CENTER);

            VBox root = new VBox(20); // Spasi antar elemen di VBox
            root.setPadding(new Insets(20)); // Padding di sekitar VBox
            root.setAlignment(Pos.CENTER);
            root.getChildren().addAll(judulLabel, inputArea, feedbackLabel, percobaanLabel);
            root.setStyle("-fx-background-color: #000000");

            Scene scene = new Scene(root, 400, 250); // Lebar dan tinggi window
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void resetGame() {
            angkaRahasia = random.nextInt(100) + 1; // Angka acak 1-100
            jumlahPercobaan = 0;
            if (percobaanLabel != null) {
                percobaanLabel.setText("Percobaan: " + jumlahPercobaan);
            }
            if (feedbackLabel != null) {
                feedbackLabel.setText("Masukkan angka dan klik 'Coba Tebak!'");
            }
            if (tebakButton != null) {
                tebakButton.setText("Coba Tebak!");
                tebakButton.setOnAction(e -> prosesTebakan()); // Set ulang aksi tombol
            }
            if (tebakanField != null) {
                tebakanField.clear();
                tebakanField.setDisable(false); // Aktifkan kembali field tebakan
            }
            System.out.println("Angka rahasia baru: " + angkaRahasia); // Untuk debugging
        }

        private void prosesTebakan() {
            try {
                int tebakan = Integer.parseInt(tebakanField.getText());
                jumlahPercobaan++;
                percobaanLabel.setText("Percobaan: " + jumlahPercobaan);

                if (tebakan < 1 || tebakan > 100) {
                    feedbackLabel.setText("Masukkan angka antara 1 dan 100!");
                } else if (tebakan < angkaRahasia) {
                    feedbackLabel.setText("Terlalu kecil!");
                    feedbackLabel.setTextFill(Color.YELLOW);
                } else if (tebakan > angkaRahasia) {
                    feedbackLabel.setText("Terlalu besar!");
                    feedbackLabel.setTextFill(Color.YELLOW);
                } else {
                    feedbackLabel.setText("Tebakan benar! Angkanya adalah " + angkaRahasia);
                    tebakButton.setText("Main Lagi");
                    tebakanField.setDisable(true); // Nonaktifkan field tebakan
                    tebakButton.setOnAction(e -> {
                        resetGame();
                        tebakanField.setDisable(false); // Aktifkan kembali setelah reset
                    });
                }
                tebakanField.clear(); // Bersihkan field setelah tebakan
            } catch (NumberFormatException e) {
                feedbackLabel.setText("Input tidak valid. Masukkan angka!");
            }
        }
    }