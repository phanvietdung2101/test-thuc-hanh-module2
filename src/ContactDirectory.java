import java.io.*;
import java.util.ArrayList;

public class ContactDirectory {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    static int currentPointer = 0;

    public void showContacts(){
        int i = currentPointer;
        int temp = currentPointer + 5;
        for(i = currentPointer; i < temp && i < contacts.size(); i++){
            System.out.println(contacts.get(i).toString());
        }
        if(i >= contacts.size()){
            currentPointer = 0;
        } else {
            currentPointer = i;
        }
    }

    public void add(Contact contact){
        contacts.add(contact);
    }

    public void add(String phoneNumber, String group, String name, String gender, String address, String birth, String email) {
        contacts.add(new Contact(phoneNumber,group,name,gender,address,birth,email));
    }

    public Contact searchByPhoneNumber(String phoneNumber){
        for(Contact contact : contacts){
            if(contact.getPhoneNumber().equals(phoneNumber)){
                return contact;
            }
        }
        return null;
    }

    public void editContact(Contact contact,String group,String name,String gender,String address,String birth, String email){
        contact.setGroup(group);
        contact.setName(name);
        contact.setGender(gender);
        contact.setAddress(address);
        contact.setBirth(birth);
        contact.setEmail(email);
    }

    public void removeContact(Contact contact){
        contacts.remove(contact);
    }

    public void readData(){
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("D:\\Quan-ly-danh-ba\\data\\contacts.csv"));
            String row = "";
            contacts = new ArrayList<>();
            while((row = csvReader.readLine()) != null){
                String[] data = row.split(",");
                add(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(){
        try {
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter("D:\\Quan-ly-danh-ba\\data\\contacts.csv"));
            for(Contact contact : contacts){
                csvWriter.write(contact.toString());
                csvWriter.newLine();
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
