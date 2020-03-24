import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        ContactDirectory contactDirectory = new ContactDirectory();
        Contact contact1 = new Contact("aa", "aa", "aa", "aa", "a", "a", "a");
        Contact contact2 = new Contact("b", "b", "b", "b", "a", "a", "a");
        Contact contact3 = new Contact("c", "c", "c", "c", "a", "a", "a");
        Contact contact4 = new Contact("d", "d", "d", "d", "a", "a", "a");
        Contact contact5 = new Contact("e", "e", "e", "e", "a", "a", "a");
        Contact contact6 = new Contact("f", "f", "f", "f", "a", "a", "a");
        Contact contact7 = new Contact("g", "g", "g", "g", "a", "a", "a");
        contactDirectory.add(contact1);
        contactDirectory.add(contact2);
        contactDirectory.add(contact3);
        contactDirectory.add(contact4);
        contactDirectory.add(contact5);
        contactDirectory.add(contact6);
        contactDirectory.add(contact7);

        choice = 1;
        String temp = "";
        do {
            showMenu();
            System.out.println("Nhập lựa chọn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    contactDirectory.showContacts();
                    while (temp.equals("")) {
                        temp = scanner.nextLine();
                        contactDirectory.showContacts();
                        if (contactDirectory.currentPointer == 0) break;
                    }
                    break;
                case 2:
                    System.out.println("Nhập sđt :");
                    String phoneNumber = scanner.nextLine();
                    while (!phoneNumber.matches("^[\\d]{9}")) {
                        System.out.println("Sđt không hợp lệ: ");
                        System.out.println("Nhập lại sđt:");
                        phoneNumber = scanner.nextLine();
                    }
                    System.out.println("Nhập nhóm :");
                    String group = scanner.nextLine();
                    System.out.println("Nhập họ tên :");
                    String name = scanner.nextLine();
                    System.out.println("Nhập giới tính :");
                    String gender = scanner.nextLine();
                    System.out.println("Nhập địa chỉ :");
                    String address = scanner.nextLine();
                    System.out.println("Nhập ngày sinh :");
                    String birth = scanner.nextLine();
                    System.out.println("Nhập email :");
                    String email = scanner.nextLine();
                    while (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                        System.out.println("Email không hợp lệ");
                        System.out.println("Nhập lại email:");
                        email = scanner.nextLine();
                    }
                    contactDirectory.add(phoneNumber, group, name, gender, address, birth, email);
                    System.out.println("Liên lạc đã được thêm vào");
                    break;
                case 3:
                    phoneNumber = "";
                    System.out.println("Nhập sđt cần sửa: ");
                    phoneNumber = scanner.nextLine();
                    Contact contact = contactDirectory.searchByPhoneNumber(phoneNumber);
                    if (contact != null) {
                        System.out.println("Nhập nhóm :");
                        group = scanner.nextLine();
                        System.out.println("Nhập họ tên :");
                        name = scanner.nextLine();
                        System.out.println("Nhập giới tính :");
                        gender = scanner.nextLine();
                        System.out.println("Nhập địa chỉ :");
                        address = scanner.nextLine();
                        System.out.println("Nhập ngày sinh :");
                        birth = scanner.nextLine();
                        System.out.println("Nhập email :");
                        email = scanner.nextLine();
                        while (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                            System.out.println("Email không hợp lệ");
                            System.out.println("Nhập lại email:");
                            email = scanner.nextLine();
                        }
                        contactDirectory.editContact(contact, group, name, gender, address, birth, email);
                        System.out.println("Chỉnh sửa thành công");
                    } else {
                        System.out.println("Không tìm thấy sđt");
                    }
                    break;
                case 4:
                    System.out.println("Nhập sđt cần xóa: ");
                    phoneNumber = scanner.nextLine();
                    contact = null;
                    contact = contactDirectory.searchByPhoneNumber(phoneNumber);
                    while (contact == null) {
                        System.out.println("Không tìm thấy sđt này");
                        System.out.println("Nhập lại sđt (enter để quay lại menu): ");
                        phoneNumber = scanner.nextLine();
                        if (phoneNumber == "")
                            break;
                        contact = contactDirectory.searchByPhoneNumber(phoneNumber);
                    }
                    if (contact != null) {
                        System.out.println("Bạn xác nhận muốn xóa (Nhập Y để xác nhận , nhập bất kì để thoát)");
                        String confirm = scanner.nextLine();
                        if (confirm.equals("Y")) {
                            contactDirectory.removeContact(contact);
                        } else
                            break;
                    }
                    break;
                case 5:
                    break;
                case 6:
//                    System.out.println("Phải cập nhật bộ nhớ trước khi đọc , nếu không sẽ mất dữ liệu");
//                    System.out.println("Nhập Y để ghi dữ liệu :");
//                    String confirm = scanner.nextLine();
//                    if (confirm.equals("Y")) {
//                        contactDirectory.readData();
//                    } else {
//                        break;
//                    }
                    contactDirectory.readData();
                    break;
                case 7:
                    contactDirectory.writeData();
                    break;
                default:
                    break;
            }
            contactDirectory.writeData();
        } while (choice != 0);

    }
    static void showMenu(){
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục) :");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
    }
}
