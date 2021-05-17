package CardValidator;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RefactoredCreditCard {

    @FXML // fx:id="my_card_image"
    private ImageView card;

    @FXML // fx:id="my_check"
    private ImageView check;

    @FXML
    private TextField cred_num;

    public void card_number(Event evt){

        // Get string.
        String card_number=String.valueOf(cred_num.getText());
        //Remove formatting
        card_number=card_number.replaceAll("\\s", "");

        //Check the credit card source
        boolean valid = false;
        if (card_number.length() > 1) {
            if (card_number.charAt(0) == '4'){
                //Set icon to visa
                valid = true;
                card.setFitHeight(30);
                card.setFitWidth(40);
                card.setImage(new Image("CardValidator/Visa2.png"));
            }
            else if (card_number.charAt(0) == '5'){
                //Set icon to Mastercard
                valid = true;
                card.setFitHeight(30);
                card.setFitWidth(60);
                card.setImage(new Image("CardValidator/MasterCard.png"));
            }
            else if (card_number.charAt(0) == '3'){
                if (card_number.length() >1){
                    if (card_number.charAt(1) == '4' || card_number.charAt(1) == '7'){
                        //Set icon to Amex
                        card.setFitHeight(30);
                        card.setFitWidth(30);

                        card.setImage(new Image("CardValidator/Amex3.png"));
                        valid = true;
                    }
                    else if (card_number.charAt(1)=='5'){
                        //Set Icon to JCB
                        card.setFitHeight(25);
                        card.setFitWidth(32.5);

                        card.setImage(new Image("CardValidator/jcb.gif"));
                        valid = true;
                    }
                }
            }
            else{
                card.setImage(null);
            }
        }

        //Check that it is all numbers
        for (int i = 0; i < card_number.length(); i++){
            if (Character.isDigit(card_number.charAt(i)) == false){
                valid = false;
            }
        }

        //Check
        if (valid == true && card_number.length() == 16)
        {
            //Set up the Check image
            check.setImage(new Image ("CardValidator/checkmark-24.png"));
        }
        else if (card_number.length() >= 16){
            //set up the X image
            check.setImage(new Image("CardValidator/x-mark-24.png"));

        }
        else{
            //Remove the image
            check.setImage(null);
        }

        //Format the text
        if (card_number.length() == 16 && valid == true ){
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < card_number.length(); i++) {
                if (i % 4 == 0 && i != 0) {
                    result.append(" ");
                }

                result.append(card_number.charAt(i));
            }

            String Proper = result.toString();
            cred_num.setText(Proper);
        }

        //Function to find the validation of the text and to format the text

    }





}
