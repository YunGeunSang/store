package app;
import java.util.Arrays;
import java.util.Scanner;

public class store {


    public static void main(String[] args) {
        // 편의점 발주 프로그램을 제작한다 showMenu()
        // 1. 물건정보 등록하기
        //      1-1. 제품명을 입력받고
        //      1-2. 등록된 제품목록 출력, show_prod()
        // 2. 물건정보 등록 취소하기
        //      2-1. 제품명을 입력받고 제거, remove_prod()
        // 3. 물건넣기
        //      3-1. 등록된 제품 및 수량 출력, showMenu()
        //      3-2. 물건을 넣을 제품명 입력, input_prod()
        //      3-3. 물건을 넣을 수량 입력
        // 4. 물건빼기
        //      4-1. 등록된 제품 및 수량 출력, show_prod()
        //      4-2. 물건을 뺄 제품명 입력
        //      4-3. 물건을 뺄 수량 입력
        // 5. 재고 조회
        //      5-1. 제품목록 출력
        // 6. 프로그램 종료

        // 변수선언
        Scanner scanner = new Scanner(System.in);
        int input;
        String prodName;
        int prodNum;
        String[] Product = new String[] {"등록 가능", "등록 가능", "등록 가능", "등록 가능", "등록 가능"};
        int[] ProductNum = new int[] {0, 0, 0, 0, 0};
        String[] inputProduct = new String[]{""};
        int[] inputProdcutNum = new int[]{0};


        //showMenu()
        System.out.println("[Item_Storeage_V3");
        System.out.println("-".repeat(30));
        System.out.println("[System] 코드스테이츠 점장님 어서오세요.");
        System.out.println("[System] 해당 프로그램의 기능입니다");

        while(true) {
            System.out.println("1. 물건 정보(제품명) 등록하기");
            System.out.println("2. 물건 정보(제품명) 등록 취소하기");
            System.out.println("3. 물건 넣기(제품 입고)");
            System.out.println("4. 물건 빼기(제품 출고)");
            System.out.println("5. 재고 조회");
            System.out.println("6. 프로그램 종료");
            System.out.println("-".repeat(30));
            System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
            input = Integer.parseInt(scanner.nextLine());

            // selectMenu()
            switch (input) {
                case 1:
                    System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
                    prodName = scanner.nextLine();

                    // 빈배열을 선언하여 입력받을때마다 크기를 1씩 증가시켜 값을 넣는다
                    inputProduct[inputProduct.length - 1] = prodName;
                    inputProduct = Arrays.copyOf(inputProduct, inputProduct.length + 1);
                    System.arraycopy(inputProduct, 0, Product, 0, inputProduct.length - 1);
                    System.out.println("[System] 등록이 완료됐습니다.");
                    System.out.println("[System] 현재 등록된 제품 목록");
                    for (int i = 0; i < Product.length; i++) {
                        System.out.printf("> %s\n", Product[i]);
                    }
                    System.out.println("-".repeat(30));
                    break;
                case 2:
                    System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
                    prodName = scanner.nextLine();
                    int index1 = Arrays.asList(Product).indexOf(prodName);
                    Product[index1] = "등록 가능";
                    ProductNum[index1] = 0;
                    System.out.println("[System] 제품 취소가 완료됐습니다");
                    System.out.println("-".repeat(30));
                    break;
                case 3:
                    System.out.print("수량을 추가할 제품명을 입력하세요 : ");
                    prodName = scanner.nextLine();
                    System.out.print("[System] 추가할 수량을 입력해주세요 : ");
                    prodNum = Integer.parseInt(scanner.nextLine());
                    int index = Arrays.asList(Product).indexOf(prodName);
                    ProductNum[index] = prodNum;
                    System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료되었습니다.");
                    System.out.println("[System] 현재 등록된 제품 및 수량");
                    for (int i = 0; i < Product.length; i++) {
                        System.out.printf("> %s : %d개\n", Product[i], ProductNum[i]);
                    }
                    System.out.println("-".repeat(30));
                    break;
                case 4:
                    System.out.println("[System] 제품의 출고를 진행합니다.");
                    System.out.println("[System] 현재 등록된 제품 및 수량");
                    for (int i = 0; i < Product.length; i++) {
                        System.out.printf("> %s : %d개\n", Product[i], ProductNum[i]);
                    }
                    System.out.print("[System] 출고를 진행할 제품명을 입력하세요 : ");
                    prodName = scanner.nextLine();
                    System.out.print("[System] 원하는 출고량을 입력하세요 : ");
                    prodNum = Integer.parseInt(scanner.nextLine());
                    int index2 = Arrays.asList(Product).indexOf(prodName);
                    ProductNum[index2] -= prodNum;
                    System.out.println("[System] 출고가 완료되었습니다");
                    System.out.println("[System] 현재 등록된 제품 및 수량");
                    for (int i = 0; i < Product.length; i++) {
                        System.out.printf("> %s : %d개\n", Product[i], ProductNum[i]);
                    }
                    System.out.println("-".repeat(30));
                    break;
                case 5:
                    System.out.println("[System] 현재 등록된 제품 및 수량");
                    for (int i = 0; i < Product.length; i++) {
                        System.out.printf("> %s : %d개\n", Product[i], ProductNum[i]);
                    }
                    System.out.println("-".repeat(30));
                    break;
                case 6:
                    System.out.println("[System] 프로그램을 종료합니다.");
                    System.out.println("[System] 감사합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }

        }


    }
}