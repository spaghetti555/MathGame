package com.example.home.mathgamev1;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        final int i1=1,i2=2,i3=3,i4=4, gaga=9;
        final int answerButton;
        final Random rand = new Random();
        final int q1 = rand.nextInt(1000);
        final int q2 = rand.nextInt(1000);
        final int answer=q1+q2;

        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(q1 + " + " + q2);

        answerButton=rand.nextInt(4)+1;


        final ProgressBar progressBar = (android.widget.ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(50);


        final Button B1= (Button) findViewById(R.id.answerOneButton);
        final Button B2 = (Button) findViewById(R.id.answerTwoButton);
        final Button B3 = (Button) findViewById(R.id.answerThreeButton);
        final Button B4 = (Button) findViewById(R.id.answerFourButton);

        final Handler handler = new Handler();

        final Runnable run1 = new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(progressBar.getProgress()-1);
                if (progressBar.getProgress()==0)
                {
                    Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                    backIntent.putExtra("winState", "You ran out of time");
                    backIntent.putExtra("newGame","New Question");
                    backIntent.putExtra("Score", 0);

                    startActivity(backIntent);
                    finish();//????????? <Aciivity android:noHistory=true"
                }
                handler.postDelayed(this,200);
            }
        };

        handler.postDelayed(run1,200);


        switch (answerButton)
        {
            case 1:
                {
                    B1.setText(""+answer);
                    B2.setText(""+rand.nextInt(2000));
                    B3.setText(""+rand.nextInt(2000));
                    B4.setText(""+rand.nextInt(2000));
                    break;
                }
            case 2:
                {
                    B2.setText(""+answer);
                    B1.setText(""+rand.nextInt(2000));
                    B3.setText(""+rand.nextInt(2000));
                    B4.setText(""+rand.nextInt(2000));
                    break;
                }
            case 3:
                {
                    B3.setText(""+answer);
                    B1.setText(""+rand.nextInt(2000));
                    B2.setText(""+rand.nextInt(2000));
                    B4.setText(""+rand.nextInt(2000));
                    break;
                }
            case 4:
                {
                    B4.setText(""+answer);
                    B1.setText(""+rand.nextInt(2000));
                    B2.setText(""+rand.nextInt(2000));
                    B3.setText(""+rand.nextInt(2000));
                    break;
                }
             default:
                {
                    break;
                }

        }


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String winState="";
                    int WinLose = rand.nextInt(5);
                if (Integer.parseInt(B1.getText().toString())==answer)
                {
                    switch (WinLose)
                    {
                        case 0:
                        {
                            winState="Congrats, win";
                            break;//aaaa
                        }
                        case 1:
                        {
                            winState="You won!";
                            break;
                        }
                        case 2:
                        {
                            winState="Easy!";
                            break;
                        }
                        case 3:
                        {
                            winState="Wow, nice!";
                            break;
                        }
                        default:
                        {
                            winState="Good Job!";
                            break;
                        }

                    }

                }
                else
                    {
                        switch (WinLose)
                        {
                            case 0:
                            {
                                winState="You lost :(";
                                break;
                            }
                            case 1:
                            {
                                winState=":(";
                                break;
                            }
                            case 2:
                            {
                                winState="Too bad";
                                break;
                            }
                            case 3:
                            {
                                winState="Very sad";
                                break;
                            }
                            default:
                            {
                                winState="Spaghetti?";
                                break;
                            }

                        }
                    }
                Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                backIntent.putExtra("winState", winState);
                backIntent.putExtra("newGame","Next Question");
                int Progress1 = progressBar.getProgress();
                int Score1 = Progress1*10;
                backIntent.putExtra("Score",Score1);
                startActivity(backIntent);
            }
        }

        );




        B2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String winState="";
                                      int WinLose = rand.nextInt(5);
                                      if (Integer.parseInt(B2.getText().toString())==answer)
                                      {
                                          switch (WinLose)
                                          {
                                              case 0:
                                              {
                                                  winState="Congrats, win";
                                                  break;
                                              }
                                              case 1:
                                              {
                                                  winState="You won!";
                                                  break;
                                              }
                                              case 2:
                                              {
                                                  winState="Easy!";
                                                  break;
                                              }
                                              case 3:
                                              {
                                                  winState="Wow, nice!";
                                                  break;
                                              }
                                              default:
                                              {
                                                  winState="Good Job!";
                                                  break;
                                              }

                                          }

                                      }
                                      else
                                      {
                                          switch (WinLose)
                                          {
                                              case 0:
                                              {
                                                  winState="You lost :(";
                                                  break;
                                              }
                                              case 1:
                                              {
                                                  winState=":(";
                                                  break;
                                              }
                                              case 2:
                                              {
                                                  winState="Too bad";
                                                  break;
                                              }
                                              case 3:
                                              {
                                                  winState="Very sad";
                                                  break;
                                              }
                                              default:
                                              {
                                                  winState="Spaghetti?";
                                                  break;
                                              }

                                          }
                                      }
                                      Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                                      backIntent.putExtra("winState", winState);
                                      backIntent.putExtra("newGame","Next Question");
                                      backIntent.putExtra("Score",progressBar.getProgress());
                                      startActivity(backIntent);
                                  }
                              }

        );




        B3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String winState="";
                                      int WinLose = rand.nextInt(5);
                                      if (Integer.parseInt(B3.getText().toString())==answer)
                                      {
                                          switch (WinLose)
                                          {
                                              case 0:
                                              {
                                                  winState="Congrats, win";
                                                  break;
                                              }
                                              case 1:
                                              {
                                                  winState="You won!";
                                                  break;
                                              }
                                              case 2:
                                              {
                                                  winState="Easy!";
                                                  break;
                                              }
                                              case 3:
                                              {
                                                  winState="Wow, nice!";
                                                  break;
                                              }
                                              default:
                                              {
                                                  winState="Good Job!";
                                                  break;
                                              }

                                          }

                                      }
                                      else
                                      {
                                          switch (WinLose)
                                          {
                                              case 0:
                                              {
                                                  winState="You lost :(";
                                                  break;
                                              }
                                              case 1:
                                              {
                                                  winState=":(";
                                                  break;
                                              }
                                              case 2:
                                              {
                                                  winState="Too bad";
                                                  break;
                                              }
                                              case 3:
                                              {
                                                  winState="Very sad";
                                                  break;
                                              }
                                              default:
                                              {
                                                  winState="Spaghetti?";
                                                  break;
                                              }

                                          }
                                      }
                                      Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                                      backIntent.putExtra("winState", winState);
                                      backIntent.putExtra("newGame","Next Question");
                                      int Progress1 = progressBar.getProgress();
                                      int Score1 = Progress1*10;
                                      backIntent.putExtra("Score",Score1);
                                      startActivity(backIntent);
                                  }
                              }

        );



        B4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      String winState="";
                                      int WinLose = rand.nextInt(5);
                                      if (Integer.parseInt(B4.getText().toString())==answer)
                                      {
                                          switch (WinLose)
                                          {
                                              case 0:
                                              {
                                                  winState="Congrats, win";
                                                  break;
                                              }
                                              case 1:
                                              {
                                                  winState="You won!";
                                                  break;
                                              }
                                              case 2:
                                              {
                                                  winState="Easy!";
                                                  break;
                                              }
                                              case 3:
                                              {
                                                  winState="Wow, nice!";
                                                  break;
                                              }
                                              default:
                                              {
                                                  winState="Good Job!";
                                                  break;
                                              }

                                          }

                                      }
                                      else
                                      {
                                          switch (WinLose)
                                          {
                                              case 0:
                                              {
                                                  winState="You lost :(";
                                                  break;
                                              }
                                              case 1:
                                              {
                                                  winState=":(";
                                                  break;
                                              }
                                              case 2:
                                              {
                                                  winState="Too bad";
                                                  break;
                                              }
                                              case 3:
                                              {
                                                  winState="Very sad";
                                                  break;
                                              }
                                              default:
                                              {
                                                  winState="Spaghetti?";
                                                  break;
                                              }

                                          }
                                      }
                                      Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                                      backIntent.putExtra("winState", winState);
                                      backIntent.putExtra("newGame","Next Question");
                                      int Progress1 = progressBar.getProgress();
                                      int Score1 = Progress1*10;
                                      backIntent.putExtra("Score",Score1);
                                      startActivity(backIntent);
                                  }
                              }

        );








    }
}
