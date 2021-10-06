import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class HelloWorld{
    
    private static class Coordenada{
        int x,y;
        
        public Coordenada(int xx, int yy) {
            x = xx;
            y = yy;
        }
        
        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
        
        public boolean equals(int a,int b) {
            return this.x == a && this.y == b;
        }
        
    }

    public static void main(String []args){
        System.out.println("Hello World");
        
        int X = 5;
        int Y = 6;
        char [][] mundo = {
            {'*','*','-','*','*','*'}, 
            {'*','-','-','-','-','*'}, 
            {'-','-','*','*','-','-'}, 
            {'-','-','-','-','-','*'}, 
            {'*','-','-','-','*','*'}
        };
        boolean starFound=false;
        int islandCount = 0;
        
        for (int i = 0; i < X; i++) {
            System.out.println("");
            for (int j = 0; j < Y; j++) {
                System.out.print(" " + mundo[i][j]);
            }
        }
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("");
        
        Map<Integer, ArrayList<Coordenada> > islas = new HashMap<Integer, ArrayList<Coordenada>>();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (mundo[i][j] == '*'){
                    starFound = false;    
                    Iterator it = islas.keySet().iterator();
                    while(it.hasNext()){
                      Integer key = Integer.parseInt(it.next().toString());
                      for (Coordenada unaCoordenada: islas.get(key)) {
                            if (unaCoordenada.equals(i,j-1) ||
                                unaCoordenada.equals(i,j+1) ||
                                unaCoordenada.equals(i-1,j) ||
                                unaCoordenada.equals(i+1,j)){
                                    Coordenada coordenada = new Coordenada(i,j);
                                    islas.get(key).add(coordenada);
                                    starFound=true;
                                    break;
                            }
                        }
                    }    
                    if (!starFound){
                        islandCount++;
                        ArrayList<Coordenada> listCoordenada = new ArrayList<>();
                        Coordenada coordenada = new Coordenada(i,j);
                        listCoordenada.add(coordenada);
                        islas.put(islandCount, listCoordenada);
                    }
                }
            }
        }
        
        Iterator it = islas.keySet().iterator();
        while(it.hasNext()){
          Integer key = Integer.parseInt(it.next().toString());
          System.out.println("Clave: " + key + " -> Valor: " + islas.get(key));
        }
        
    }
}
