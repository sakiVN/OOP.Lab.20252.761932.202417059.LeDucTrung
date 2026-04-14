package AimsPackage;
 class TestPassingParameter {
    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("\nAfter changeTitle:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
    }

    // swap sai (theo đề bài)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
     /* // Swap đúng:
      public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
          String tempTitle = o1.getTitle();
          o1.setTitle(o2.getTitle());
          o2.setTitle(tempTitle);
      }
     */

    // changeTitle
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); // đặt setter tạm thời

        DigitalVideoDisc tempDVD = new DigitalVideoDisc(oldTitle);
        dvd = tempDVD;
    }
}