import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> dP1(){
        List <Object[]> list=new ArrayList<>();
        list.add(new Object[]{"Buba","Buba@gmail.com","Jungle","USA"});
        list.add(new Object[]{"Duba","Duba@gmail.com","Jungle","Dubai"});
        list.add(new Object[]{"Cuba","Cuba@gmail.com","Jungle","Cuba"});
        return list.listIterator();


    }
    @DataProvider
    public Iterator<Object []> dP(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{User.builder().name("Buba").email("Buba@gmail.com").caddress("Jungle").paddress("USA").build()});
        list.add(new Object[]{User.builder().name("Duba").email("Duba@gmail.com").caddress("Jungle").paddress("Dubai").build()});
        list.add(new Object[]{User.builder().name("Cuba").email("Cuba@gmail.com").caddress("Jungle").paddress("Cuba").build()});
        return list.listIterator();
    }
    @DataProvider
    public Iterator<Object []> regValidDataCSV() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/dataForSecondTest.csv")));
        String line= reader.readLine();
        while(line!=null){
            String [] sp=line.split(",");
            list.add(new Object[]{sp[0],sp[1],sp[2],sp[3]});
            line= reader.readLine();
        }
        return list.listIterator();
    }
}
