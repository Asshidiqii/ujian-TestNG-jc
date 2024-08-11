package com.juaracoding;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ATMTest {
    private ATM atm;

    // Metode yang dijalankan sebelum setiap tes untuk menginisialisasi objek ATM
    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000);
    }

    // Menguji apakah metode lihatSaldo() mengembalikan saldo yang benar
    @Test
    public void testLihatSaldo() {
        assertEquals(atm.lihatSaldo(), 1000.0);
    }

    // Menguji apakah metode setorUang() berfungsi dengan benar ketika jumlah yang valid disetor
    @Test
    public void testSetorUang() {
        atm.setorUang(500);
        assertEquals(atm.lihatSaldo(), 1500.0);
    }

    // Menguji apakah metode setorUang() melempar pengecualian ketika jumlah yang negatif disetor
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-100);
    }

    // Menguji apakah metode tarikUang() berfungsi dengan benar ketika jumlah yang valid ditarik
    @Test
    public void testTarikUang() {
        atm.tarikUang(500);
        assertEquals(atm.lihatSaldo(), 500.0);
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang ditarik melebihi saldo saat ini
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(1500);
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang negatif ditarik
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-100);
    }
}