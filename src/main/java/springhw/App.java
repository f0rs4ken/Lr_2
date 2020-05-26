package springhw;

import springhw.beans.adds.*;
import springhw.beans.Counter;
import springhw.beans.Menu;
import springhw.beans.Parser;
import springhw.beans.Printer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhw.beans.HelloBean;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

	    // Первая лаба:

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = in.next();
        Parser parser = new Parser(filename);
        Characters[] data = parser.parse();
        byte choose;
        do {
            choose = Menu.main_menu();
            switch (choose){
                case 1:
                    Printer.print_all(data);
                    break;
                case 2:
                    Counter.count(data);
                    break;
                case 3:
                    Printer.ptint_for_user(data);
                    break;
                case 4:
                    System.out.println("Close the program");
                    break;
            }
        } while (choose != 4);

        //-----------------------------------------------------------------------------------------------------------------------------------------------------

        // Примеры Жевнерчука:
		
		// Создаем контекст приложения из xml файла("src/main/resources/applicationContext.xml")
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //-----------------------------------------------------------------------------------------------------------------------------------------------------
        
        // Считываем бины (объекты) и печатаем их в консоль
        System.out.println(ctx.getBean("firstBean", HelloBean.class));
        System.out.println(ctx.getBean("secondBean", HelloBean.class));
        
           // Можете посмотреть в консоли, что два раза напечатан один и тот же объект с id=="thirdBean", потому что у него по умолчанию scope == "singleton"
           // Смотрите код ссылки на метод toString, которая выводится в конце каждой строчки. Они одинаковые   
        System.out.println(ctx.getBean("thirdBean", HelloBean.class));
        System.out.println(ctx.getBean("thirdBean", HelloBean.class));
        
           // Можете посмотреть в консоли, что по одному разу напечатаны две разных копии бина с id=="fourthBean", потому что у него установлен scope == "prototype"
           // Смотрите код ссылки на метод toString, которая выводится в конце каждой строчки. Они разные
        System.out.println(ctx.getBean("fourthBean", HelloBean.class));
        System.out.println(ctx.getBean("fourthBean", HelloBean.class));

        //-----------------------------------------------------------------------------------------------------------------------------------------------------
        
        // Закрываем контекст приложения 
        ctx.close();
	}

}