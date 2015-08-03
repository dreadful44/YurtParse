import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class main{



    public static void main(String[] args){
        List<String> URLUni = extraParse();
        Document doc2 = null;
        
                List<String> liste = new ArrayList<String>();
                for (int b = 0; b < URLUni.size(); b++) {
                    try {
                        doc2 = Jsoup.connect(URLUni.get(b)).get();
                    } catch (Exception e) {

                    }
                    if(doc2!=null) {

                        try {
                            for(int c=0; c<100; c++) {
                                if(doc2.select("a.siyah_baslik").get(c)!=null) {
                                    Element link = doc2.select("a.siyah_baslik").get(c);
                                    liste.add("http://www.yurtarama.com/" + link.attr("href"));
                                }else
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.printf("Ana başlık araması tamamlandı.\t" + URLUni.get(b) + "\n");
                        }

                        try {

                            for(int d=0; d<100; d++) {
                                if(doc2.select(".index_icerik_yazilar_kucuk .index_icerik_yazilar_1").get(d)!=null) {
                                    Element link = doc2.select(".index_icerik_yazilar_kucuk .index_icerik_yazilar_1").get(d);
                                    liste.add("http://www.yurtarama.com/" + link.attr("href"));
                                }else
                                    break;
                            }

                        } catch (Exception e) {
                            System.out.printf("Başlık araması tamamlandı.\t" + URLUni.get(b) + "\n");
                        }
                    }
                }
        if(liste!=null && liste.size()!=0) {
            verileriAl(liste);
        }



    }
    public static List<String> extraParse () {
        List<String> ciktiUrller = new ArrayList<String>();
        String html = "<td align=\"left\" valign=\"middle\" class=\"index_icerik_yazilar_1\" height=\"21\" style=\"padding-bottom:5px; padding-left:10px; padding-top:5px; padding-right:10px;\">\n" +

                "                                      &nbsp;<a href=\"k-antalya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-20.html\" class=\"index_icerik_yazilar_4\" title=\"Antalya Öğrenci Yurtları / Pansiyonlar\">Antalya</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-ardahan-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-77.html\" class=\"index_icerik_yazilar_1\" title=\"Ardahan Öğrenci Yurtları / Pansiyonlar\">Ardahan</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-artvin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-21.html\" class=\"index_icerik_yazilar_2\" title=\"Artvin Öğrenci Yurtları / Pansiyonlar\">Artvin</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-aydin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-22.html\" class=\"index_icerik_yazilar_3\" title=\"Aydın Öğrenci Yurtları / Pansiyonlar\">Aydın</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-balikesir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-23.html\" class=\"index_icerik_yazilar_4\" title=\"Balıkesir Öğrenci Yurtları / Pansiyonlar\">Balıkesir</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bartin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-76.html\" class=\"index_icerik_yazilar_1\" title=\"Bartın Öğrenci Yurtları / Pansiyonlar\">Bartın</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-batman-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-74.html\" class=\"index_icerik_yazilar_2\" title=\"Batman Öğrenci Yurtları / Pansiyonlar\">Batman</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bayburt-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-71.html\" class=\"index_icerik_yazilar_3\" title=\"Bayburt Öğrenci Yurtları / Pansiyonlar\">Bayburt</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bilecik-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-5.html\" class=\"index_icerik_yazilar_4\" title=\"Bilecik Öğrenci Yurtları / Pansiyonlar\">Bilecik</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bingol-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-24.html\" class=\"index_icerik_yazilar_1\" title=\"Bingöl Öğrenci Yurtları / Pansiyonlar\">Bingöl</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bitlis-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-25.html\" class=\"index_icerik_yazilar_2\" title=\"Bitlis Öğrenci Yurtları / Pansiyonlar\">Bitlis</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bolu-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-4.html\" class=\"index_icerik_yazilar_3\" title=\"Bolu Öğrenci Yurtları / Pansiyonlar\">Bolu</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-burdur-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-26.html\" class=\"index_icerik_yazilar_4\" title=\"Burdur Öğrenci Yurtları / Pansiyonlar\">Burdur</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-bursa-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-8.html\" class=\"index_icerik_yazilar_1\" title=\"Bursa Öğrenci Yurtları / Pansiyonlar\">Bursa</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-canakkale-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-27.html\" class=\"index_icerik_yazilar_2\" title=\"Çanakkale Öğrenci Yurtları / Pansiyonlar\">Çanakkale</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-cankiri-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-28.html\" class=\"index_icerik_yazilar_3\" title=\"Çankırı Öğrenci Yurtları / Pansiyonlar\">Çankırı</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-corum-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-29.html\" class=\"index_icerik_yazilar_4\" title=\"Çorum Öğrenci Yurtları / Pansiyonlar\">Çorum</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-denizli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-30.html\" class=\"index_icerik_yazilar_1\" title=\"Denizli Öğrenci Yurtları / Pansiyonlar\">Denizli</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-diyarbakir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-31.html\" class=\"index_icerik_yazilar_2\" title=\"Diyarbakır Öğrenci Yurtları / Pansiyonlar\">Diyarbakır</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-duzce-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-3.html\" class=\"index_icerik_yazilar_3\" title=\"Düzce Öğrenci Yurtları / Pansiyonlar\">Düzce</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-edirne-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-32.html\" class=\"index_icerik_yazilar_4\" title=\"Edirne Öğrenci Yurtları / Pansiyonlar\">Edirne</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-elazig-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-33.html\" class=\"index_icerik_yazilar_1\" title=\"Elazığ Öğrenci Yurtları / Pansiyonlar\">Elazığ</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-erzincan-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-34.html\" class=\"index_icerik_yazilar_2\" title=\"Erzincan Öğrenci Yurtları / Pansiyonlar\">Erzincan</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-erzurum-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-35.html\" class=\"index_icerik_yazilar_3\" title=\"Erzurum Öğrenci Yurtları / Pansiyonlar\">Erzurum</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-eskisehir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-12.html\" class=\"index_icerik_yazilar_4\" title=\"Eskişehir Öğrenci Yurtları / Pansiyonlar\">Eskişehir</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-gaziantep-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-36.html\" class=\"index_icerik_yazilar_1\" title=\"Gaziantep Öğrenci Yurtları / Pansiyonlar\">Gaziantep</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-giresun-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-37.html\" class=\"index_icerik_yazilar_2\" title=\"Giresun Öğrenci Yurtları / Pansiyonlar\">Giresun</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-gumushane-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-38.html\" class=\"index_icerik_yazilar_3\" title=\"Gümüşhane Öğrenci Yurtları / Pansiyonlar\">Gümüşhane</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-hakkari-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-39.html\" class=\"index_icerik_yazilar_4\" title=\"Hakkari Öğrenci Yurtları / Pansiyonlar\">Hakkari</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-hatay-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-40.html\" class=\"index_icerik_yazilar_1\" title=\"Hatay Öğrenci Yurtları / Pansiyonlar\">Hatay</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-igdir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-78.html\" class=\"index_icerik_yazilar_2\" title=\"Iğdır Öğrenci Yurtları / Pansiyonlar\">Iğdır</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-isparta-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-41.html\" class=\"index_icerik_yazilar_3\" title=\"Isparta Öğrenci Yurtları / Pansiyonlar\">Isparta</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-istanbul-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-9.html\" class=\"index_icerik_yazilar_4\" title=\"İstanbul Öğrenci Yurtları / Pansiyonlar\">İstanbul</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-izmir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-10.html\" class=\"index_icerik_yazilar_1\" title=\"İzmir Öğrenci Yurtları / Pansiyonlar\">İzmir</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kahramanmaras-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-49.html\" class=\"index_icerik_yazilar_2\" title=\"Kahramanmaraş Öğrenci Yurtları / Pansiyonlar\">Kahramanmaraş</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-karabuk-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-80.html\" class=\"index_icerik_yazilar_3\" title=\"Karabük Öğrenci Yurtları / Pansiyonlar\">Karabük</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-karaman-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-72.html\" class=\"index_icerik_yazilar_4\" title=\"Karaman Öğrenci Yurtları / Pansiyonlar\">Karaman</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kars-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-2.html\" class=\"index_icerik_yazilar_1\" title=\"Kars Öğrenci Yurtları / Pansiyonlar\">Kars</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kastamonu-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-43.html\" class=\"index_icerik_yazilar_2\" title=\"Kastamonu Öğrenci Yurtları / Pansiyonlar\">Kastamonu</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kayseri-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-44.html\" class=\"index_icerik_yazilar_3\" title=\"Kayseri Öğrenci Yurtları / Pansiyonlar\">Kayseri</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kibris-kktc-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-84.html\" class=\"index_icerik_yazilar_4\" title=\"Kıbrıs (KKTC) Öğrenci Yurtları / Pansiyonlar\">Kıbrıs (KKTC)</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kirikkale-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-73.html\" class=\"index_icerik_yazilar_1\" title=\"Kırıkkale Öğrenci Yurtları / Pansiyonlar\">Kırıkkale</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kirklareli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-11.html\" class=\"index_icerik_yazilar_2\" title=\"Kırklareli Öğrenci Yurtları / Pansiyonlar\">Kırklareli</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kirsehir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-14.html\" class=\"index_icerik_yazilar_3\" title=\"Kırşehir Öğrenci Yurtları / Pansiyonlar\">Kırşehir</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kilis-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-81.html\" class=\"index_icerik_yazilar_4\" title=\"Kilis Öğrenci Yurtları / Pansiyonlar\">Kilis</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kocaeli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-6.html\" class=\"index_icerik_yazilar_1\" title=\"Kocaeli Öğrenci Yurtları / Pansiyonlar\">Kocaeli</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-konya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-45.html\" class=\"index_icerik_yazilar_2\" title=\"Konya Öğrenci Yurtları / Pansiyonlar\">Konya</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-kutahya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-46.html\" class=\"index_icerik_yazilar_3\" title=\"Kütahya Öğrenci Yurtları / Pansiyonlar\">Kütahya</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-malatya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-47.html\" class=\"index_icerik_yazilar_4\" title=\"Malatya Öğrenci Yurtları / Pansiyonlar\">Malatya</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-manisa-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-48.html\" class=\"index_icerik_yazilar_1\" title=\"Manisa Öğrenci Yurtları / Pansiyonlar\">Manisa</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-mardin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-50.html\" class=\"index_icerik_yazilar_2\" title=\"Mardin Öğrenci Yurtları / Pansiyonlar\">Mardin</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-mersin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-42.html\" class=\"index_icerik_yazilar_3\" title=\"Mersin Öğrenci Yurtları / Pansiyonlar\">Mersin</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-mugla-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-51.html\" class=\"index_icerik_yazilar_4\" title=\"Muğla Öğrenci Yurtları / Pansiyonlar\">Muğla</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-mus-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-52.html\" class=\"index_icerik_yazilar_1\" title=\"Muş Öğrenci Yurtları / Pansiyonlar\">Muş</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-nevsehir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-53.html\" class=\"index_icerik_yazilar_2\" title=\"Nevşehir Öğrenci Yurtları / Pansiyonlar\">Nevşehir</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-nigde-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-54.html\" class=\"index_icerik_yazilar_3\" title=\"Niğde Öğrenci Yurtları / Pansiyonlar\">Niğde</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-ordu-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-55.html\" class=\"index_icerik_yazilar_4\" title=\"Ordu Öğrenci Yurtları / Pansiyonlar\">Ordu</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-osmaniye-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-82.html\" class=\"index_icerik_yazilar_1\" title=\"Osmaniye Öğrenci Yurtları / Pansiyonlar\">Osmaniye</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-rize-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-56.html\" class=\"index_icerik_yazilar_2\" title=\"Rize Öğrenci Yurtları / Pansiyonlar\">Rize</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-sakarya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-1.html\" class=\"index_icerik_yazilar_3\" title=\"Sakarya Öğrenci Yurtları / Pansiyonlar\">Sakarya</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-samsun-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-57.html\" class=\"index_icerik_yazilar_4\" title=\"Samsun Öğrenci Yurtları / Pansiyonlar\">Samsun</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-siirt-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-58.html\" class=\"index_icerik_yazilar_1\" title=\"Siirt Öğrenci Yurtları / Pansiyonlar\">Siirt</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-sinop-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-59.html\" class=\"index_icerik_yazilar_2\" title=\"Sinop Öğrenci Yurtları / Pansiyonlar\">Sinop</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-sivas-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-60.html\" class=\"index_icerik_yazilar_3\" title=\"Sivas Öğrenci Yurtları / Pansiyonlar\">Sivas</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-sanliurfa-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-65.html\" class=\"index_icerik_yazilar_4\" title=\"Şanlıurfa Öğrenci Yurtları / Pansiyonlar\">Şanlıurfa</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-sirnak-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-75.html\" class=\"index_icerik_yazilar_1\" title=\"Şırnak Öğrenci Yurtları / Pansiyonlar\">Şırnak</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-tekirdag-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-61.html\" class=\"index_icerik_yazilar_2\" title=\"Tekirdağ Öğrenci Yurtları / Pansiyonlar\">Tekirdağ</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-tokat-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-62.html\" class=\"index_icerik_yazilar_3\" title=\"Tokat Öğrenci Yurtları / Pansiyonlar\">Tokat</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-trabzon-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-63.html\" class=\"index_icerik_yazilar_4\" title=\"Trabzon Öğrenci Yurtları / Pansiyonlar\">Trabzon</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-tunceli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-64.html\" class=\"index_icerik_yazilar_1\" title=\"Tunceli Öğrenci Yurtları / Pansiyonlar\">Tunceli</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-usak-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-66.html\" class=\"index_icerik_yazilar_2\" title=\"Uşak Öğrenci Yurtları / Pansiyonlar\">Uşak</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-van-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-67.html\" class=\"index_icerik_yazilar_3\" title=\"Van Öğrenci Yurtları / Pansiyonlar\">Van</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-yalova-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-79.html\" class=\"index_icerik_yazilar_4\" title=\"Yalova Öğrenci Yurtları / Pansiyonlar\">Yalova</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-yozgat-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-68.html\" class=\"index_icerik_yazilar_1\" title=\"Yozgat Öğrenci Yurtları / Pansiyonlar\">Yozgat</a>&nbsp;&nbsp;\n" +
                "                                      &nbsp;<a href=\"k-zonguldak-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-69.html\" class=\"index_icerik_yazilar_2\" title=\"Zonguldak Öğrenci Yurtları / Pansiyonlar\">Zonguldak</a>&nbsp;&nbsp;\n" +
                "                                    </td>";

        Document doc = Jsoup.parse(html);
        for(int abc=25; abc<35;abc++) {
            try {
                Element link = doc.select("a").get(abc);
                ciktiUrller.add("http://www.yurtarama.com/" + link.attr("href"));
            }catch (Exception e) {
                
            }


        }
        return ciktiUrller;

    }
    public static void verileriAl(List<String> URLInformation) {
        List<Yurt> liste = new ArrayList<Yurt>();
        Document doc = null;

        for(int i=0;i<URLInformation.size();i++) {
            Yurt yurt = new Yurt();
            try {
                doc = Jsoup.connect(URLInformation.get(i)).get();
            } catch (Exception e) {

            }
            if(doc!=null) {

                try{
                    String turu = doc.select(".firma_iletisim_yazi_yeni").first().text();
                    if(turu.contains("Erkek"))
                        yurt.setTuru(1);

                    if(turu.contains("Kız"))
                        yurt.setTuru(2);
                }
                catch (Exception e) {
                    yurt.setTuru(0);
                    System.out.printf("yurt turunde hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    yurt.setAdi(doc.select(".firma_baslik").first().text());
                }
                catch (Exception e) {
                    yurt.setAdi("");
                    System.out.printf("yurt adında hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    String il = doc.select(".yol").first().text();
                    il = il.substring(34,il.indexOf(" ›",35));
                    yurt.setIli(il);
                }
                catch (Exception e) {
                    yurt.setIli("");
                    System.out.printf("yurt ilinde hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Adres")) {
                            yurt.setAdres(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setAdres("");
                    }

                }
                catch (Exception e) {
                    yurt.setAdres("");
                    System.out.printf("yurt adresinde hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Sabit")) {
                            yurt.setSabitTelefon(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setSabitTelefon("");
                    }
                }
                catch (Exception e) {
                    yurt.setSabitTelefon("");
                    System.out.printf("yurt sabit telefon hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Cep")) {
                            yurt.setCepTelefonu(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setCepTelefonu("");
                    }

                } catch (Exception e) {
                    yurt.setCepTelefonu("");
                    System.out.printf("yurt setCep_telefonu hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Web") &&
                                doc.select(".yurt_yazi1").get(j).text().startsWith("www")) {
                            yurt.setWebSitesi(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setWebSitesi("");
                    }

                } catch (Exception e) {
                    yurt.setWebSitesi("");
                    System.out.printf("yurt web adresi hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Büyüklüğü")) {
                            String kapasite = doc.select(".yazi5_bold").get(j).text();
                            kapasite = kapasite.substring(kapasite.indexOf(":")+2,kapasite.length());
                            yurt.setKapasite(Integer.parseInt(kapasite));
                            break;
                        }
                        else
                            yurt.setKapasite(0);
                    }

                } catch (Exception e) {
                    yurt.setKapasite(0);
                    System.out.printf("yurt setKapasite hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("E-Posta")) {
                            yurt.setEmail(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setEmail("");
                    }

                } catch (Exception e) {
                    yurt.setEmail("");
                    System.out.printf("yurt Email hata bulundu " + URLInformation.get(i) + "\n");
                }


                try{
                    yurt.setAciklama(doc.select(".firma_onemli_bilgi").first().text());

                } catch (Exception e) {
                    yurt.setAciklama("");
                    System.out.printf("yurt setAciklama hata bulundu " + URLInformation.get(i) + "\n");
                }
                liste.add(yurt);
            }

        }
        kaydet(liste);
    }
    public static void kaydet (List<Yurt> list) {
        SessionFactory factory;
        try{
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for(int a = 0; a<list.size(); a++)
                session.save(list.get(a));
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /*public static void veriyiKaydet (List<Yurt> list) {
        Connection baglanti = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            baglanti = DriverManager.getConnection("jdbc:mysql://localhost/yurt?useUnicode=true&characterEncoding=UTF-8", "root", "");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "";

        for (int j = 0; j < list.size(); j++) {
            sql += ("INSERT INTO `yurt`.`yurt` (`turu`, `ili`, `adi`, `adres`, `sabit_telefon`," +
                    " `cep_telefonu`, `web_sitesi`, `email`, " +
                    "`kapasite`, `aciklama`, `imkanlari`, `koordinatlar`, " +
                    "`fotograf_on_ek`, `fotograf_sayisi`)"+
                    "VALUES (" + "'"+ list.get(j).getTuru() +"',"+

                    "'"+ list.get(j).getIli() + "',"+
                    "'"+ list.get(j).getAdi() + "',"+
                    "'"+ list.get(j).getAdres() + "',"+
                    "'"+ list.get(j).getSabitTelefon() + "',"+
                    "'"+ list.get(j).getCepTelefonu() + "'"+
                    "'"+ list.get(j).getWebSitesi() + "',"+
                    "'"+ list.get(j).getEmail() + "',"+
                    "'"+ list.get(j).getKapasite() + "',"+
                    "'"+ list.get(j).getAciklama() + "',"+
                    "'"+ list.get(j).getImkanlari() + "',"+
                    "'"+ list.get(j).getKoordinatlar() + "',"+
                    "'"+ list.get(j).getFotografOnEk() + "',"+
                    "'"+ list.get(j).getFotografSayisi() + "');");
        }
        try {
            statement = baglanti.createStatement();
            statement.executeUpdate(sql);
            System.out.println("# Veritabanı yazma işlemi tamamlandı...");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("# Veri tabanına kaydederken sorun yaşandı...");
        } catch (SQLException e) {
            System.out.println("# Kaydetme işlemi başarısız...");
        }
    }*/


    /*private static void writeXlSFile(List<Yurt> list)
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

        Map<String, List<String>> empData = new HashMap<String, List<String>>();
        List<String> basliklar = new ArrayList<String>();
        basliklar.add("id");
        basliklar.add("turu");
        basliklar.add("ili");
        basliklar.add("adi");
        basliklar.add("adres");
        basliklar.add("sabit_telefon");
        basliklar.add("cep_telefonu");
        basliklar.add("web_sitesi");
        basliklar.add("email");
        basliklar.add("kapasite");
        basliklar.add("aciklama");
        basliklar.add("imkanlari");
        basliklar.add("koordinatlar");
        basliklar.add("fotograf_on_ek");
        basliklar.add("fotograf_sayisi");
        empData.put("1", basliklar);
        for(int i=0;i<list.size();i++) {
            List<String> veriler = new ArrayList<String>();
            
            Yurt yurt = list.get(i);
*//*            veriler.add(String.valueOf(yurt.getId()));
            veriler.add(String.valueOf(yurt.getTuru()));
            veriler.add(yurt.getIli());*//*
            veriler.add(yurt.getAdi());
*//*            veriler.add(yurt.getAdres());
            veriler.add(yurt.getSabit_telefon());
            veriler.add(yurt.getCep_telefonu());
            veriler.add(yurt.getWeb_sitesi());
            veriler.add(yurt.getWeb_sitesi());*//*
            empData.put(String.valueOf(i+2), veriler);
        }
        Set<String> keyset = empData.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            List<String> nameList = empData.get(key);
            int cellnum = 0;
            for (Object obj : nameList)
            {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                {
                    cell.setCellValue((Date) obj);
                }
                else if (obj instanceof Boolean)
                {
                    cell.setCellValue((Boolean) obj);
                }
                else if (obj instanceof String)
                {
                    cell.setCellValue((String) obj);
                }
                else if (obj instanceof Double)
                {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        try
        {
            String path = "write.xls";
            FileOutputStream out =
                    new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException :" + e);
        }
        catch (IOException e)
        {
            System.out.println("IOException :" + e);
        }
    }*/
    }
