package com.example.rhythym_guard;

import java.util.ArrayList;

public class userlist {
    ArrayList<MainModel>arrayList = new ArrayList<>();

    public ArrayList<MainModel> getRecords() {
        ArrayList<MainModel> recordList = arrayList;
        return recordList;


    }

    /**
     * Adds one's health records.
     *
     * @param userClass
     *      The health record to be added.
     */
    public void add(MainModel userClass) {
        if(arrayList.contains(userClass))
        {
            throw new IllegalArgumentException();
        }
        arrayList.add(userClass);
    }

    /**
     * Deletes one's health records.
     *
     * @param userClass
     *      The health record to be deleted.
     */
    public void delete(MainModel userClass)
    {
        if(!arrayList.contains(userClass))
        {
            throw new IllegalArgumentException();
        }
        arrayList.remove(userClass);
    }

    /**
     * Updates the health records with new data at the specified position.
     *
     * @param position
     *      The position at which the records are being updated.
     * @param userClass
     *      The updated health record.
     */
    public void update(int position, MainModel userClass)
    {
        arrayList.set(position, userClass);
    }
}
