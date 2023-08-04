package view;

import presenter.Presenter;

import java.util.Scanner;

import model.ETypeProduct;
import model.Product;

public class Runner {
    private Presenter presenter;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runner runner = new Runner();
        runner.presenter = new Presenter();
        Product[] productsInWareHouse = new Product[8];
        productsInWareHouse[0] = new Product("King Soap", 2300, 30, true, ETypeProduct.ASEO);
        productsInWareHouse[1] = new Product("Arrox x lb", 4600, 80, false, ETypeProduct.VIVERES);
        productsInWareHouse[2] = new Product("Old par x lt", 180000, 18, true, ETypeProduct.LICORES);
        productsInWareHouse[3] = new Product("Pancake", 1500, 342, false, ETypeProduct.RANCHO);
        productsInWareHouse[4] = new Product("Cereal", 2300, 30, true, ETypeProduct.RANCHO);
        productsInWareHouse[5] = new Product("Coca cola", 4600, 80, false, ETypeProduct.VIVERES);
        productsInWareHouse[6] = new Product("Ron", 180000, 18, true, ETypeProduct.LICORES);
        productsInWareHouse[7] = new Product("Pasta", 1500, 342, false, ETypeProduct.RANCHO);
        int totalSales = 0;
        int totalAmountSales = 0;
        do {
            try {
                System.out.println("1. Agregar venta");
                System.out.println("2. Salir");
                char option = scanner.nextLine().charAt(0);
                switch (option) {
                    case '1':
                        char optionProduct = 0;
                        boolean isContinue = true;
                        do {
                            try {
                                Product product = null;
                                System.out.println("\n1. King Soap");
                                System.out.println("2. Arrox x lb");
                                System.out.println("3. Old par x lt");
                                System.out.println("4. Pancake");
                                System.out.println("5. Cereal");
                                System.out.println("6. Coca cola");
                                System.out.println("7. Ron");
                                System.out.println("8. Pasta");
                                System.out.println("9. Salir");
                                optionProduct = scanner.nextLine().charAt(0);
                                int quantity = 0;
                                if (optionProduct == "1".charAt(0) || optionProduct == "2".charAt(0) ||
                                        optionProduct == "3".charAt(0) || optionProduct == "4".charAt(0) ||
                                        optionProduct == "5".charAt(0) || optionProduct == "6".charAt(0) ||
                                        optionProduct == "7".charAt(0) || optionProduct == "8".charAt(0)) {
                                    System.out.println("Cantidad: ");
                                    quantity = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                switch (optionProduct) {
                                    case '1':
                                        product = productsInWareHouse[0];
                                        break;
                                    case '2':
                                        product = productsInWareHouse[1];
                                        break;
                                    case '3':
                                        product = productsInWareHouse[2];
                                        break;
                                    case '4':
                                        product = productsInWareHouse[3];
                                        break;
                                    case '5':
                                        product = productsInWareHouse[4];
                                        break;
                                    case '6':
                                        product = productsInWareHouse[5];
                                        break;
                                    case '7':
                                        product = productsInWareHouse[6];
                                        break;
                                    case '8':
                                        product = productsInWareHouse[7];
                                        break;
                                    case '9':
                                        isContinue = false;
                                        break;
                                    default:
                                        System.out.println("Opción inválida");
                                        break;
                                }
                                if (optionProduct == "1".charAt(0) || optionProduct == "2".charAt(0) ||
                                        optionProduct == "3".charAt(0) || optionProduct == "4".charAt(0) ||
                                        optionProduct == "5".charAt(0) || optionProduct == "6".charAt(0) ||
                                        optionProduct == "7".charAt(0) || optionProduct == "8".charAt(0)) {
                                    System.out.println("Cantidad: ");
                                    double totalSale = runner.presenter.addSale(product.getName(),
                                            product.getValue(),
                                            product.getStock(), product.isIva(), product.getTypeProduct(),
                                            quantity);
                                    totalAmountSales += totalSale;
                                    if (totalSale == 0.0) {
                                        System.out.println("No se pudo realizar la venta");
                                    } else {
                                        System.out.println(runner.presenter.showSale());
                                        totalSales++;
                                    }
                                }
                            } catch (Exception e) {
                                isContinue = true;
                            }
                        } while (isContinue);
                        break;
                    case '2':
                        System.out.println("Total de ventas: " + totalAmountSales);
                        System.out.println("Promedio de ventas: " + totalAmountSales / totalSales);
                        System.out.println("Saliendo...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (Exception e) {
                if (e instanceof ArithmeticException) {
                    System.out.println("You have not added any sales");
                    System.out.println("Exit");
                    System.exit(0);
                }
                System.out.println("Enter a correct option");
            }
        } while (true);
    }
}
