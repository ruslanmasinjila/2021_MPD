package com.example.fragmentcommunication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {


    private final MutableLiveData<Person> selectedPerson = new MutableLiveData<Person>();

    public void setSelectedPerson(Person person)
    {
        selectedPerson.setValue(person);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

    public LiveData<Person> getSelectedPerson()
    {
        System.out.println("Getting Person");
        return selectedPerson;
    }
}