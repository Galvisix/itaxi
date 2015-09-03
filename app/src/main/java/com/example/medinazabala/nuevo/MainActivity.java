package com.example.medinazabala.nuevo;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TabHost;


public class MainActivity extends ActionBarActivity {
        TabHost th;
        private Button btnCompartir;
        private Button btnFavoritos;
        private Button btnCalificar;
        //private Chronometer chronometer;


    @Override
    public View findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.tab);  //se saca porque sino se solapan



        //fragmentManager = getSupportFragmentManager();

            th=(TabHost)findViewById(R.id.th);
            //---------------------------------------------------------------------------
            th.setup();
            TabHost.TabSpec ts1=th.newTabSpec("Tab1");
            ts1.setIndicator("", getResources().getDrawable(R.drawable.compartir));
            ts1.setContent(R.id.tab1);
            th.addTab(ts1);

            //--------------------------------------------------------------------------------
            th.setup();
            TabHost.TabSpec ts2=th.newTabSpec("Tab2");
            ts2.setIndicator("", getResources().getDrawable(R.drawable.favorito));
            ts2.setContent(R.id.tab2);
            th.addTab(ts2);
            //---------------------------------------------------------------------------------
            th.setup();
            TabHost.TabSpec ts3=th.newTabSpec("Tab3");
            ts3.setIndicator("", getResources().getDrawable(R.drawable.calificar));
            ts3.setContent(R.id.tab3);
            th.addTab(ts3);
            //------------------botones------------------------------------------------------------
            btnCompartir=(Button)findViewById(R.id.et1);
            btnFavoritos=(Button)findViewById(R.id.btn1);
            btnCalificar=(Button)findViewById(R.id.tv1);

            btnCompartir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =
                            new Intent(MainActivity.this,compartir.class);
                    startActivity(intent);
                }
            });

            btnFavoritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=
                        new Intent(MainActivity.this,favorito.class);
                    startActivity(intent1);


                }
            });

            btnCalificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2=
                            new Intent(MainActivity.this,calificar.class);
                    startActivity(intent2);
                }
            });


            //------------------fin Botones--------------------------------------------------------
            ActionBar actionBar = getSupportActionBar();

            /**INDICAR TITULO Y SUBTITULO**/
            actionBar.setTitle("   ");
            actionBar.setSubtitle("  ");


            /**MODO TABS EN ACTIONBAR**/
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            //actionBar.
            /**CREAR TABS**/
            ActionBar.Tab tab = actionBar.newTab()
                    .setIcon(R.drawable.opciones)

                    .setTabListener(new TabsListener(
                            this, "ubicacion", FragmentsProducto.class));
            actionBar.addTab(tab);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            tab = actionBar.newTab()
                    .setIcon(R.drawable.taxi)

                    .setTabListener(new TabsListener(
                            this, "tiempo", FragmentsCliente.class));
            actionBar.addTab(tab);

            tab = actionBar.newTab()
                    .setIcon(R.drawable.configuracion)

                    .setTabListener(new TabsListener(
                            this, "configuracion", FragmentsPedido.class));
            actionBar.addTab(tab);


        }

        public class TabsListener  implements ActionBar.TabListener {

            private Fragment fragment;
            private final String tag;

            public TabsListener(Activity activity, String tag, Class cls) {
                this.tag = tag;
                fragment = Fragment.instantiate(activity, cls.getName());
            }

            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                ft.replace(android.R.id.content, fragment, tag);


            }

            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                ft.remove(fragment);
            }

            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
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


    }


