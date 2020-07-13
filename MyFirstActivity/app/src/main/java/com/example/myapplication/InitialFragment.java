package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InitialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InitialFragment extends Fragment {



    String[] cityNamesArray = {
            "Moscow",
            "Saint-Petersburg",
            "Warsaw",
            "New York",
            "Sydney",
            "Tokyo"
    };
    Integer[] imagesArray = {
            R.drawable.rainbow,
            R.drawable.sun,
            R.drawable.wind,
            R.drawable.winter,
            R.drawable.sunglasses,
            R.drawable.moon
    };
    String[] weatherArray = {
            "Rainy",
            "Sunny",
            "Windy",
            "Frosty",
            "Heat",
            "Mild"
    };
    String[] temperatureArray = {
            "15",
            "24",
            "10",
            "-10",
            "+40",
            "+5"
    };
    String[] humidityArray = {
            "59 %",
            "65 %",
            "45 %",
            "50 %",
            "80 %",
            "76 %"
    };
    String[] pressureArray = {
            "743 мм. р",
            "600 мм. р",
            "845 мм. р",
            "665 mm р",
            "720 mm p",
            "7600 mm p"
    };



    private FragmentActivity myContext;    //-------------------------------------------------------------------changed 08.07.2020







    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InitialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment initialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InitialFragment newInstance(String param1, String param2) {
        InitialFragment fragment = new InitialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    //-------------------------------------------------------------------changed 08.07.2020
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.initial_fragment, container, false);
        SearchView searchView = (SearchView) view.findViewById(R.id.searchViewId);
        //обработка ввода текста и его отправка
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                boolean flag = false;
                String ct = null;
                //пробегаемся по списку имебщихся город и сравниваем с тем, что ввели. Я понимаю, что нужен некий фильтр еще здесь, но пока  так
                for (String city : cityNamesArray) {
                    if (city.equals(query)) {
                       // textView.setText(query);
                      //  test.setData(query);  //записываем результат поиска в класс реальзованный по паттерну singleton
                      //  Intent app = new Intent(getActivity(),ChoosenCityActivity.class);
                      //  app.putExtra("city",query);
                      //  startActivity(app);
                        flag = true;
                       ct = city;
                       // return false;
                    } else {
                      //  Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                    }

                }
                if(flag){
                    CityWeatherDescription cwd = CityWeatherDescription.newInstance(ct,"work");
                   // CityWeatherDescription ctW = getActivity().getSupportFragmentManager().findFragmentById(R.id.cityWeatherFrameID);


                   // FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ///--------------------------------------------------
                    FragmentTransaction ft = ((AppCompatActivity)myContext).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.initialFramLayoutId,cwd)
                            .addToBackStack(cwd.getClass().getName())
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);    //--------------changed 08.07.2020

                    ft.commit();
                    return true;


                }
               // test.setData("No Match found");     //записываем результат поиска в класс реальзованный по паттерну singleton
               // textView.setText(test.data);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



    }
}

/*

        final TextView textView = findViewById(R.id.textTestExample);         //текстовое поле в которое будут записываться данные из поиска
        textView.setText(test.data); //запись данныхв это текстовое поля под поиском. Сейчас туда запишутся данные из синглтона, дефолтеное. В нашем случае просто "Test"

        searchView = (SearchView) findViewById(R.id.searchViewId);

        //обработка ввода текста и его отправка
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                  //пробегаемся по списку имебщихся город и сравниваем с тем, что ввели. Я понимаю, что нужен некий фильтр еще здесь, но пока  так
                for (String city : cityNamesArray) {
                    if (city.equals(query)) {
                        textView.setText(query);
                        test.setData(query);  //записываем результат поиска в класс реальзованный по паттерну singleton
                        Intent app = new Intent(MainActivity.this,ChoosenCityActivity.class);
                        app.putExtra("city",query);
                        startActivity(app);
                        return false;
                    } else {
                        Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                    }

                }
                test.setData("No Match found");     //записываем результат поиска в класс реальзованный по паттерну singleton
                textView.setText(test.data);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

          //блок проверов для последующего вывода результата в лог и Toast
        if (instanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            counter++;
            instanceState = "Запуск номер: " + counter;

        }


        CustomList customList = new CustomList(this, imagesArray, cityNamesArray, weatherArray, temperatureArray, humidityArray, pressureArray);
        listView = (ListView) findViewById(R.id.favListView);
        listView.setAdapter(customList);



        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent app = new Intent(MainActivity.this,ChoosenCityActivity.class);

                startActivity(app);
            }
        });


        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getName(), instanceState + " - onCreate()");

 */