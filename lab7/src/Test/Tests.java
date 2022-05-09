package Test;
import Broadcasting.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;

public class Tests extends Assert{
    Cartoon up = new Cartoon("Cartoon", "Up!", 2009, 96);
    Cartoon coco = new Cartoon("Cartoon", "Coco", 2017, 105);
    Cartoon shrek = new Cartoon("Cartoon", "Shrek", 2001, 92);
    Cartoon toy = new Cartoon("Cartoon", "Toy story", 1995, 81);



    @BeforeMethod
    public void beforeMethod() {
        System.out.println("���� ����� ����������� ����� ������ �������� �������.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("���� ����� ����������� ����� ������� ��������� ������.");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("���� ����� ����� ����������� ����� ������ ������� � ����� �� ��������� �����.");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("���� ����� ����� ����������� ����� ���� ������� � ����� �� ��������� �����.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("���� ����� ����� �������� �� ���� �������� ������� ��������� ������.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("���� ����� ����� ������� ����� ���� �������� ������� � ������� ������.");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("���� ����� ����� ����������� �� ���� �������� �������");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("���� ����� ����� ������� ����� ���� �������� �������, ������������� ������� ������ ���� <test>.");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("���� ����� ����� ����������� ����� ����� ������� ��������� ������.");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("���� ����� ����� ����������� ����� ���� ������� ��������� ������.");
    }


    @Test
    public void testingAdd(){
        ArrayList<Cartoon> cartoons = new ArrayList<>();

        cartoons.add(up);
        cartoons.add(coco);

        for(Cartoon car : cartoons){
            System.out.println(car.getInfo());
        }

        Assert.assertNotNull(cartoons); //���������, ��� ������ �� �������� null
    }

    @Test(timeOut = 1500)
    public void testingSize(){
        ArrayList<Cartoon> cartoons = new ArrayList<>();

        cartoons.add(up);
        cartoons.add(coco);
        Assert.assertEquals(2, cartoons.size()); //���������� ����������� � ���������
    }


    @Test(enabled = false)
    public void testAddStudentsIgnore() {
        ArrayList<Cartoon> cartoons = new ArrayList<>();

        cartoons.add(up);
        cartoons.add(coco);

        for(Cartoon car : cartoons){
            System.out.println(car.getInfo());
        }
        System.out.println("���� ����� ����� �������������� � ������ ���������� ������������!");
        Assert.assertNotNull(cartoons);

    }

    @Test(groups={"unit1","integration"})
    public void testingMethod1() {
        System.out.println("testingMethod1---------------------");
        System.out.println(up.getInfo());
    }

    @Test(groups={"unit2","integration"})
    public void testingMethod2() {
        System.out.println("testingMethod2----------------------");
        System.out.println(shrek.getInfo());
    }

    @Test(groups={"unit1"})
    public void testingMethod3() {
        System.out.println("testingMethod3----------------------");
        System.out.println(coco.getInfo());
    }

    @Test(groups={"unit1", "unit2"})
    public void testingMethod4() {
        System.out.println("testingMethod4----------------------");
        System.out.println(toy.getInfo());
    }

}
