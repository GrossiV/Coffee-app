package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class JustJavaActivity extends AppCompatActivity {

    int coffes = 0;
    double pricecoffe = 5.0, pricetop1, pricetop2, total = 0;
    String msg = "", name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
    }

    //metodo que obtem o nome
    public void obterNome() {
        EditText userName = (EditText) findViewById(R.id.name_field);
        name = userName.getText().toString();
        msg = "Name: " + name;
    }

    //metodo que ativa o botão de pedido
    public void submitOrder(View view) {
        EditText userName = (EditText) findViewById(R.id.name_field);
        name = userName.getText().toString();
        if (coffes <= 0) {
            Toast.makeText(this, "Sorry, how many coffes?", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ordered!", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo que ativa o botão de "+", também chama o método de exibição e de calculo do preço
    public void submitIncrement(View view) {
        coffes++;
        displayQuantity(coffes);
        totalPrice();
    }

    //metodo que ativa o botão de "-", também chama o metodo de exibição e de calculo de preço
    public void submitDecrement(View view) {
        coffes--;
        if (coffes <= 0) {
            Toast.makeText(this, "Sorry, how many coffes?", Toast.LENGTH_SHORT).show();
            coffes = 0;
        }
        displayQuantity(coffes);
        totalPrice();
    }

    //ao marcar chama o método de calculo de preço
    public void choc(View view) {

        totalPrice();
    }

    //ao marcar chama o método de calculo de preço
    public void wc(View view) {

        totalPrice();
    }

    //exibe a quantidade de copos de cafes
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    //exibe a mensagem de texto na tela
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    //calculo da cobertura de chocolate
    private void checkBoxChoc() {
        CheckBox ChocolateBox = (CheckBox) findViewById(R.id.wc_choc);
        if (ChocolateBox.isChecked() == true) {
            msg += "\nExtra + $2 per coffe (topping)";
            pricetop2 = (2 * coffes);
            total += pricetop2;
        }
    }

    //calculo da cobertura de creme
    private void checkBox() {
        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_wc);
        if (WhippedCreamCheckBox.isChecked() == true) {
            msg += "\nExtra + $1.5 per coffe (topping)";
            pricetop1 = (1.5 * coffes);
            total += pricetop1;
        }
    }

    //calcula o preço, chama o metodo de obter nome, os de cobertura e o de exibição de texto
    private void totalPrice() {
        total = 0;
        pricecoffe *= coffes;
        total += pricecoffe;
        obterNome();
        msg += "\nSubTotal: $";
        msg += (pricecoffe);
        checkBox();
        checkBoxChoc();
        msg += "\nTotal: $";
        msg += total;
        displayMessage(msg);
        pricecoffe = 5.0;
    }
}