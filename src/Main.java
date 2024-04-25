import java.util.ArrayList;
import java.util.List;

class Item {
    private String nama;
    private int harga;
    private int stok;

    public Item(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan setter untuk atribut-atribut
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Metode untuk menampilkan informasi item
    public void infoItem() {
        System.out.println("Nama: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }
}


class Weapon extends Item {
    private int damage;

    public Weapon(String nama, int harga, int stok, int damage) {
        super(nama, harga, stok);
        this.damage = damage;
    }

    @Override
    public void infoItem() {
        super.infoItem(); 
        System.out.println("Damage: " + damage);
    }
}


class Potion extends Item {
    private String effect;

    public Potion(String nama, int harga, int stok, String effect) {
        super(nama, harga, stok);
        this.effect = effect;
    }

    @Override
    public void infoItem() {
        super.infoItem(); 
        System.out.println("Effect: " + effect);
    }
}
// class armor extends Item {
//     private String defense;

//     public armor(String nama, int harga, int stok, String defense) {
//         super(nama, harga, stok);
//         this.defense = defense;
//     }

//     @Override
//     public void infoItem() {
//         super.infoItem(); // Memanggil metode infoItem() dari superclass
//         System.out.println("defense: " + defense);
//     }
// }


class Inventory {
    private List<Item> daftarItem;
    private int totalHarga; 

    public Inventory() {
        this.daftarItem = new ArrayList<>();
        this.totalHarga = 0; // Inisialisasi total harga pembelian
    }

 
    public void tambahItem(Item item) {
        daftarItem.add(item);
        totalHarga += item.getHarga(); 
    }


    public void hapusItem(Item item) {
        daftarItem.remove(item);
        totalHarga -= item.getHarga(); 
    }

 
    public void tampilkanInventory() {
        for (Item item : daftarItem) {
            item.infoItem();
            System.out.println();
        }
    }

    // Getter untuk mendapatkan total harga pembelian
    public int getTotalHarga() {
        return totalHarga;
    }
}


public class Main {
    public static void main(String[] args) {
        Item item1 = new Weapon("Pedang", 100, 1, 15);
        Item item2 = new Potion("Potion", 50, 10, "Heals 20 HP");
        // Item item3 = new Potion("Potion", 50, 10, "Heals 20 HP");

        Inventory inventory = new Inventory();
        inventory.tambahItem(item1);
        inventory.tambahItem(item2);
        // inventory.tambahItem(item3);
        // inventory.hapusItem(item1);
        inventory.tampilkanInventory();
        System.out.println("Total harga pembelian: " + inventory.getTotalHarga());

        int hargaItem1 = item1.getHarga();
        System.out.println("Harga item1: " + hargaItem1);
        item1.setHarga(200);
        int stokItem1 = item1.getStok();
        System.out.println("Harga " + item1.getNama() + " setelah diubah: " + item1.getHarga());
        System.out.println("Stok item1: " + stokItem1);
        
        // item1.setStok(10);
        // System.out.println("Stok setelah diubah: " + item1.getStok());
        // inventory.tampilkanInventory();
    }
}
