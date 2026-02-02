package PTIT_CNTT1_IT203A_Session01;

public class Exercise03 {
    public static void main(String[] args) {

        String book1 = "Java Basic";
        String book2 = "Python Intro";

        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);

        /*
         GIAI THICH BO NHO (STACK & HEAP)

         - "Java Basic" va "Python Intro" la cac doi tuong String,
           duoc luu trong vung nho HEAP (String Pool).

         - book1, book2, temp la cac bien tham chieu,
           duoc luu trong vung nho STACK.

         TRINH TU HOAN DOI:

         1. book1 --> "Java Basic"
            book2 --> "Python Intro"

         2. temp = book1
            temp --> "Java Basic"
            (Heap khong tao chuoi moi, chi them 1 tham chieu)

         3. book1 = book2
            book1 --> "Python Intro"

         4. book2 = temp
            book2 --> "Java Basic"

         KET LUAN:
         - Du lieu trong HEAP (cac chuoi) khong thay doi.
         - Chi cac bien tham chieu tren STACK thay doi dia chi tro toi.
         - Java khong hoan doi truc tiep du lieu, ma hoan doi tham chieu.
        */
    }
}
