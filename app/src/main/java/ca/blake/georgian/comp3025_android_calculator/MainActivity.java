package ca.blake.georgian.comp3025_android_calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Value variables
    private String displayString = "";
    private String currentNumber = "";
    private String lastButtonPushed = "";
    private String lastOperator = "";
    private Double prevNum = 0.0;
    private Double total = 0.0;
    private int buttonsClicked = 0;

    private TextView _displayLabel;

    // Button variables
    private Button _ACButton;
    private Button _divisionButton;
    private Button _multiplicationButton;
    private Button _additionButton;
    private Button _subtractionButton;
    private Button _equalsButton;
    private Button _decimalButton;
    private Button _powerOfButton;
    private Button _zeroButton;
    private Button _oneButton;
    private Button _twoButton;
    private Button _threeButton;
    private Button _fourButton;
    private Button _fiveButton;
    private Button _sixButton;
    private Button _sevenButton;
    private Button _eightButton;
    private Button _nineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create reference for Button controls
        this._ACButton = (Button) findViewById(R.id.ACButton);
        this._additionButton = (Button) findViewById(R.id.additionButton);
        this._subtractionButton = (Button) findViewById(R.id.subtractionButton);
        this._multiplicationButton = (Button) findViewById(R.id.multiplyButton);
        this._divisionButton = (Button) findViewById(R.id.divideButton);
        this._equalsButton = (Button) findViewById(R.id.equalsButton);
        this._decimalButton = (Button) findViewById(R.id.decimalButton);
        this._powerOfButton = (Button) findViewById(R.id.powerOfButton);
        this._zeroButton = (Button) findViewById(R.id.zeroButton);
        this._oneButton = (Button) findViewById(R.id.oneButton);
        this._twoButton = (Button) findViewById(R.id.twoButton);
        this._threeButton = (Button) findViewById(R.id.threeButton);
        this._fourButton = (Button) findViewById(R.id.fourButton);
        this._fiveButton = (Button) findViewById(R.id.fiveButton);
        this._sixButton = (Button) findViewById(R.id.sixButton);
        this._sevenButton = (Button) findViewById(R.id.sevenButton);
        this._eightButton = (Button) findViewById(R.id.eightButton);
        this._nineButton = (Button) findViewById(R.id.nineButton);

        // Create reference for Display Label
        this._displayLabel = (TextView) findViewById(R.id.displayLabel);
        _displayLabel.setText("0");

        // Create a click listener for
        this._ACButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastOperator = "";
                currentNumber = "";
                prevNum = 0.0;
                total = 0.0;
                displayString = "";
                _displayLabel.setText("0");
            }
        });

        // Create a click listener for
        this._additionButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastButtonPushed.equals("+") || lastButtonPushed.equals("-") || lastButtonPushed.equals("*") || lastButtonPushed.equals("/") || lastButtonPushed.equals("^") || buttonsClicked == 0) {
                    _displayLabel.setText(displayString);
                } else {
                    checkCalc();
                    lastOperator = "+";
                    displayString += "+";
                    _displayLabel.setText(displayString);
                    lastButtonPushed = "+";
                    buttonsClicked++;
                }
            }
        });

        // Create a click listener for
        this._subtractionButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastButtonPushed.equals("+") || lastButtonPushed.equals("-") || lastButtonPushed.equals("*") || lastButtonPushed.equals("/") || lastButtonPushed.equals("^") || buttonsClicked == 0) {
                    _displayLabel.setText(displayString);
                } else {
                    checkCalc();
                    lastOperator = "-";
                    displayString += "-";
                    _displayLabel.setText(displayString);
                    lastButtonPushed = "-";
                    buttonsClicked++;
                }
            }
        });

        // Create a click listener for
        this._multiplicationButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastButtonPushed.equals("+") || lastButtonPushed.equals("-") || lastButtonPushed.equals("*") || lastButtonPushed.equals("/") || lastButtonPushed.equals("^") || buttonsClicked == 0) {
                    _displayLabel.setText(displayString);
                } else {
                    checkCalc();
                    lastOperator = "*";
                    displayString += "*";
                    _displayLabel.setText(displayString);
                    lastButtonPushed = "*";
                    buttonsClicked++;
                }
            }
        });

        // Create a click listener for
        this._divisionButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastButtonPushed.equals("+") || lastButtonPushed.equals("-") || lastButtonPushed.equals("*") || lastButtonPushed.equals("/") || lastButtonPushed.equals("^") || buttonsClicked == 0) {
                    _displayLabel.setText(displayString);
                } else {
                    checkCalc();
                    lastOperator = "/";
                    displayString += "/";
                    _displayLabel.setText(displayString);
                    lastButtonPushed = "/";
                    buttonsClicked++;
                }
            }
        });

        // Create a click listener for
        this._equalsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastButtonPushed.equals("+") || lastButtonPushed.equals("-") || lastButtonPushed.equals("*") || lastButtonPushed.equals("/") || lastButtonPushed.equals("^") || buttonsClicked == 0) {
                    _displayLabel.setText(displayString);
                } else if (lastOperator.equals("")) {
                    total = Double.parseDouble(displayString);
                    _displayLabel.setText(displayString);
                } else {
                    checkCalc();
                    lastOperator = "";
                    displayString = total.toString();
                    currentNumber = total.toString();
                    _displayLabel.setText(displayString);
                }
            }
        });

        // Create a click listener for
        this._decimalButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentNumber.equals("")) {
                    currentNumber += "0.";
                    displayString += "0.";
                } else {
                    currentNumber += ".";
                    displayString += ".";
                }
                _displayLabel.setText(displayString);
                lastButtonPushed = ".";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._powerOfButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastButtonPushed.equals("+") || lastButtonPushed.equals("-") || lastButtonPushed.equals("*") || lastButtonPushed.equals("/") || lastButtonPushed.equals("^") || buttonsClicked == 0) {
                    // Do nothing here
                    _displayLabel.setText(displayString);
                } else {
                    checkCalc();
                    lastOperator = "^";
                    displayString += "^";
                    _displayLabel.setText(displayString);
                    lastButtonPushed = "^";
                    buttonsClicked++;
                }
            }
        });

        // Create a click listener for
        this._zeroButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "0";
                displayString += "0";
                _displayLabel.setText(displayString);
                lastButtonPushed = "0";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._oneButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "1";
                displayString += "1";
                _displayLabel.setText(displayString);
                lastButtonPushed = "1";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._twoButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "2";
                displayString += "2";
                _displayLabel.setText(displayString);
                lastButtonPushed = "2";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._threeButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "3";
                displayString += "3";
                _displayLabel.setText(displayString);
                lastButtonPushed = "3";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._fourButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "4";
                displayString += "4";
                _displayLabel.setText(displayString);
                lastButtonPushed = "4";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._fiveButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "5";
                displayString += "5";
                _displayLabel.setText(displayString);
                lastButtonPushed = "5";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._sixButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "6";
                displayString += "6";
                _displayLabel.setText(displayString);
                lastButtonPushed = "6";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._sevenButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "7";
                displayString += "7";
                _displayLabel.setText(displayString);
                lastButtonPushed = "7";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._eightButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "8";
                displayString += "8";
                _displayLabel.setText(displayString);
                lastButtonPushed = "8";
                buttonsClicked++;
            }
        });

        // Create a click listener for
        this._nineButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNumber += "9";
                displayString += "9";
                _displayLabel.setText(displayString);
                lastButtonPushed = "9";
                buttonsClicked++;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This is the checkCalc method. It is a utility method that contains all
     * calculation checking for the calculator.
     */
    public void checkCalc() {
        if (lastOperator.equals("")) {
            prevNum = Double.parseDouble(currentNumber);
            currentNumber = "";
        }
        else if (!lastOperator.equals("")) {
            if (lastOperator.equals("+")) {
                total = prevNum + Double.parseDouble(currentNumber);
                displayString = total.toString();
                prevNum = total;
                currentNumber = "";
            } else if (lastOperator.equals("-")) {
                total = prevNum - Double.parseDouble(currentNumber);
                displayString = total.toString();
                prevNum = total;
                currentNumber = "";
            } else if (lastOperator.equals("*")) {
                total = prevNum * Double.parseDouble(currentNumber);
                displayString = total.toString();
                prevNum = total;
                currentNumber = "";
            } else if (lastOperator.equals("/")) {
                total = prevNum / Double.parseDouble(currentNumber);
                displayString = total.toString();
                prevNum = total;
                currentNumber = "";
            } else if (lastOperator.equals("^")) {
                total = Math.pow(prevNum, Double.parseDouble(currentNumber));
                displayString = total.toString();
                prevNum = total;
                currentNumber = "";
            }
        }
    }
}
