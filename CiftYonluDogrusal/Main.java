package CiftYonluDogrusal;

public class Main
{
    public static void main(String[] args)
    {
        linkedList liste = new linkedList();
        Main mainObj = new Main();

        /* --------------------------------------------------------------- */
        // INSERT KODU

//        mainObj.insert(liste,1);
//        mainObj.print(liste);
//        System.out.println("-------");
//
//        mainObj.insert(liste,3);
//        mainObj.print(liste);
//        System.out.println("-------");
//
//        mainObj.insert(liste,5);
//        mainObj.print(liste);
//        System.out.println("-------");

        /* --------------------------------------------------------------- */
        //ORDERLY INSERT KODU

//        mainObj.orderlyInsert(liste, 3); // bos listeye ekliyoruz
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.orderlyInsert(liste, 2); // root degerini degistiriyoruz
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.orderlyInsert(liste, 6); // sona eleman ekliyoruz
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.orderlyInsert(liste, 5); // araya eleman ekliyoruz
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.orderlyInsert(liste, 1); // rootu tekrar degisiyoruz
//        mainObj.print(liste);
//        System.out.println("------");
//
//        System.out.println("OrderlyInsert - Delete Gecisi");
//
//        System.out.println("-------");

        /* --------------------------------------------------------------- */
        // DELETE KODU

//        mainObj.delete(liste,1); // rootu silelim
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.delete(liste,123); // olmayan elemani silelim
//        System.out.println("Liste:");
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.delete(liste,6); // son elemani silelim
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.delete(liste,3); // aradan eleman silelim
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.delete(liste,2); // tekrar rootu silelim
//        mainObj.print(liste);
//        System.out.println("------");
//
//        mainObj.delete(liste,5); // ve tekrar rootu silelim (son eleman)
//        mainObj.print(liste); // -ilk listebos(print) ciktisi
//        System.out.println("------");
//
//        mainObj.delete(liste,232323); // liste bos oldugu icin sayinin onemi yok
//        // liste bos oldugu icin listebos(delete) ciktisini verecek
//
//        mainObj.print(liste); // -ikinci listebos(print) ciktisi
//        System.out.println("------");


    }
    void insert(linkedList liste, int data)
    {
        Node yeniDugum = new Node(data);
        if(liste.root == null) // liste bos ise root yap
             liste.root = yeniDugum;
        else
        { // liste 1 olsun, 3 ekleyelim, 5 ekleyelim
            Node iter = liste.root;
            while(iter.next != null) // iter 1 de ---- 5 ekleyelim
                iter=iter.next;
            iter.next = yeniDugum; // 1 in nexti 3  ---- 3 un nexti 5
            yeniDugum.prev = iter; // 3un prev i 1 ----- 5in previ 3
        }
    }
    void print(linkedList liste)
    {
        if(liste.root == null)
            System.out.println("Liste Bos(Print Methodu)");
        else
        {
            Node iter = liste.root;
            while(iter.next != null)
            {
                System.out.println(iter.data);
                iter=iter.next;
            }
            System.out.println(iter.data);
        }
    }
    void orderlyInsert(linkedList liste, int data)
    {
        Node yeniDugum = new Node(data);
        if(liste.root == null) // liste bos ise
            liste.root = yeniDugum;
        else
        { // 3 listede, 2 eklicez
            if(yeniDugum.data < liste.root.data) // eleman rootdan kucuk ise
            {
                liste.root.prev = yeniDugum;  // 3 un previousu 2 olsun
                yeniDugum.next = liste.root; // 2 nin nexti 3 olsun
                liste.root = yeniDugum; // 2 root olsun
            }
            else
            {
                Node iter = liste.root;
                //while aciklamasi: eger iter sona gelmemis ise VE iterin nexti yeni elemandan kucukse ilerlet
                while(iter.next != null && iter.next.data < yeniDugum.data)
                    iter = iter.next;  // 2 3 gibi dusun

                Node temp = iter.next;  // 6 ekleyelim, iter 3, iter.next nulla esit
                iter.next = yeniDugum; // 3un nextini 6 yapti
                yeniDugum.next = temp; // 6nın nextini null yapti
                yeniDugum.prev = iter; // 6nin previni 3 yapti

                if(temp!=null)  // temp null olursa eger, null un previousu olmaz hata verir.
                    temp.prev =yeniDugum;  // bu hatanin onune gectik

                /* ustteki kodun aynisi icin sonraki asamada (6 yi ekledikten sonra 5 eklemek istersek)

                   5 ekleyelim dedik, iter 3te cunku: while a gore 5<6
                  -- 3 un nexti su anda 6, 6yi tempe atiyoruz
                  -- 3u nextini 5 yapiyoruz
                  -- 5 in nextini temp yani 6 yapiyoruz
                  -- 5 in previni iter yani 3 yapiyoruz.

                  -- temp!= null ise temp.prev = yeniDugum;
                  yani: temp 6 oldugu icin, 6nin previni 5 yaptik
                  eger temp null olsaydi, nullun prev ve next degeri olamayacagi icin hata verirdi

                 */

                 // -----------------------------------------------------------------


                /* ACIKLAMA
                    kendim yazmistim, Kodu anlatmak icin comment yapmis olalim

                    --- ustteki kodun 2 ye genisletilmis versiyonu gibi dusun
                    ustteki tek kodla ikisinin isini de yapiyor,
                    if ve else kararlarina gerek kalmiyor, program daha az calisiyor (onemli)

                    -----------------------------------------------------------

                if(iter.next == null) // eger listenin sonuna ekleyecekse (iter sonda)
                { // 6 ekleyelim, iter 3te
                    iter.next = yeniDugum; // 3un nexti 6
                    yeniDugum.prev = iter; // 6 nın previ 3
                }
                else // iter arada bir yerde ise ( liste 2 3 6 olsun, 5 ekleyelim)
                {
                    Node temp = iter.next; // iter 3te, tempte 6 yı tutuyor

                    iter.next = yeniDugum; //3 un nextine 5 bagliyor
                    yeniDugum.prev = iter; // 5in prev ine 3(iter) bagliyor

                    yeniDugum.next = temp; // 5 in nextine 6(temp) bagliyor
                    temp.prev = yeniDugum; // 6nin previne 5 bagliyor
                }

                  ----------------------------------------------------------------
                */
            }
        }
    }
    void delete(linkedList liste, int silinecekData)
    {
        Node silinecekDugum = new Node(silinecekData);
        if(liste.root == null)
            System.out.println("Liste Bos (Delete Methodu)");

        else if(liste.root.data == silinecekDugum.data) // silinecek eleman root ise
        {
            liste.root = liste.root.next;
            if(liste.root != null) // null olursa eger hata verirdi (nullun previousu olamaz)
                liste.root.prev = null; // baglantiyi kopartmak icin
        }
        else // arada ise ya da yoksa
        {
            Node iter = liste.root;
            while(iter.next != null && iter.next.data != silinecekDugum.data)
                iter=iter.next;

            if(iter.next == null)
                System.out.println("Silinmesi istenen eleman listede bulunamamistir.");

            else // diger durum: iter.next.data == silinecekDugum.data dir
            {
                    iter.next=iter.next.next;  // 3 - 4 - 5 liste olsun, 4 u silecegiz
                // iter 3 te duruyor. 3un nextini 5 yapiyoruz


					if(iter.next!=null) // eger null degil ise - (null ise hata verirdi)
						iter.next.prev=iter;


                    /*  eger 3 un nexti 5 degil de null olsaydi hata verirdi

                        Ornegin 4 u sildikten sonra 5i silecek olalim.

                        iter 3 te durdu, iterin nextini null yapiyoruz
                        (next'inin nexti null cunku 5 son eleman)

                        su anda iter.next == null oldugundan dolayi
                        iter.next.prev diyerek erisemeyiz

                        bu nedenle if(iter.next!=null) kontrolu var.
                    */

            }
        }
    }
}
