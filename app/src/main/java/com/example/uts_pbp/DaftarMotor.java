package com.example.uts_pbp;

import java.util.ArrayList;

public class DaftarMotor {
    public ArrayList<Motor> MOTOR;

    public DaftarMotor() {
        MOTOR = new ArrayList();
        MOTOR.add(Beat);
        MOTOR.add(Mio);
        MOTOR.add(Scoopy);
        MOTOR.add(R25);
        MOTOR.add(Verza);
        MOTOR.add(Vixion);
        MOTOR.add(DTracker);
        MOTOR.add(KLX);
        MOTOR.add(KTM);
    }

    public static final Motor Beat = new Motor("Beat", "Matic", "Masih Oke, servis rutin, baru dipakai 3x",
            "2020", "Rp 75.000/hari", "https://ecs7.tokopedia.net/img/cache/700/product-1/2020/2/6/3497675/3497675_6b379422-26f9-49a3-ad9d-9cc852eaa82a_515_515");

    public static final Motor Mio = new Motor("Mio", "Matic", "Mulus, servis rutin, kualitas seperti baru",
            "2019", "Rp 65.000/hari", "https://ecs7.tokopedia.net/img/cache/700/product-1/2020/6/16/104125037/104125037_b9befbe6-6b60-4da2-87ec-2cc503b9d6cc_800_800");

    public static final Motor Scoopy = new Motor("Scoopy", "Matic", "Cukup oke, spare part masih ada yang menggunakan model lama",
            "2017", "Rp 50.000/hari", "https://cf.shopee.co.id/file/4ad0a0c6553f8c31bd0e6dfcced54d42");

    public static final Motor R25 = new Motor("R25", "Sport", "Mulus, terawat",
            "2019", "Rp 175.000/hari", "https://ecs7.tokopedia.net/img/cache/700/product-1/2020/2/7/35146531/35146531_b97388d8-a20b-43c2-93fd-2be42f78ef13_560_560");

    public static final Motor Verza = new Motor("Verza", "Sport", "Mulus, kondisi masih oke",
            "2018", "Rp 135.000/hari", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/12/20/32235829/32235829_8e29861a-4510-4f24-8192-39a14ce11775_972_972.jpg");

    public static final Motor Vixion = new Motor("Vixion", "Sport", "Tidak terawat, jarang diservis",
            "2016", "Rp 95.000/hari", "https://s1.bukalapak.com/img/1188550339/original/data.png");

    public static final Motor DTracker = new Motor("DTracker", "Trail", "Mulus, masih baru dan terawat",
            "2020", "Rp 170.000/hari", "https://ecs7.tokopedia.net/img/cache/700/product-1/2019/8/15/31917517/31917517_2627f104-985d-4158-ad0b-51d847212dce_1000_1000");

    public static final Motor KLX = new Motor("KLX", "Trail", "Oke, terawat dan servis rutin",
            "2018", "Rp 150.000/hari", "https://ecs7.tokopedia.net/img/cache/700/product-1/2019/1/26/48353447/48353447_55f6a64e-85ab-47c1-a335-dd577b3ba88b_700_700.jpg");

    public static final Motor KTM = new Motor("KTM", "Trail", "Bagus, kondisi oke dan terawat",
            "2019", "Rp 100.000/hari", "https://www.motortrail.id/pub/media/catalog/product/cache/207e23213cf636ccdef205098cf3c8a3/2/0/2019-ktm-65-sx3.jpg");
}
