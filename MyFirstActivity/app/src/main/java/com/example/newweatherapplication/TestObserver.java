package com.example.newweatherapplication;

import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//для проверки как работает слушатель

public class TestObserver implements PropertyChangeListener {
      public TestObserver(Manager manager){
          manager.addChangeListener(this);
      }
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        System.out.println("Измененное поле: " + propertyChangeEvent.getPropertyName() + " [старое значение -> "
                + propertyChangeEvent.getOldValue() + "] | [новое значение -> " + propertyChangeEvent.getNewValue() +"]");

    }
}
