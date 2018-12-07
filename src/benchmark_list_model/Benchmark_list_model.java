
package benchmark_list_model;
import benchmark_list.*;
import java.util.Observable;

public class Benchmark_list_model extends Observable
{

    private List<Benchmark_list_ergebnis> liste;
    private int nr;
    
    public Benchmark_list_model() 
    {
        liste = new List();
    }
    
    public void hinzufuegen(int scoreGPU, int scoreCPU)
    {
        liste.append(new Benchmark_list_ergebnis(scoreGPU, scoreCPU, nr + 1));
        nr++;
        setChanged();
        notifyObservers();
    }
    
    public void entfernen(int nummer)
    {
        liste.toFirst();
        
        while(liste.hasAccess())
        {
            if(nummer == Integer.valueOf(liste.getContent().getNummer()))
            {
                liste.remove();
                this.nr --;
                break;
            }
            
            liste.next();
        }
        setChanged();
        notifyObservers();
    }
   
    public void filtern()
    {
        Benchmark_list_ergebnis[] array = new Benchmark_list_ergebnis[nr];
        Benchmark_list_ergebnis temp;
        liste.toFirst();
        
        for(int i = 0; liste.hasAccess(); i++)
        {
            array[i] = liste.getContent();
            liste.next();
        }
        
        liste.toFirst();
        
        while(liste.hasAccess())
            liste.remove();
        if(nr != 0)
            for(int i = 1; i < array.length; i++) 
            {
                for(int j = 0; j < array.length - i; j++) 
                {
                    if(Integer.valueOf(array[j].getScoreGPU()) + Integer.valueOf(array[j].getScoreCPU()) < Integer.valueOf(array[j + 1].getScoreGPU()) + Integer.valueOf(array[j + 1].getScoreCPU()))
                    {
                        temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }

                }
            }
        
        for(int i = 0; i < array.length; i++)
            liste.append(array[i]);
        
        setChanged();
        notifyObservers();
    }
    
    @Override
    public String toString()
    {
        String string = "";
        liste.toFirst();
        
        while(liste.hasAccess())
        {
            string += liste.getContent().toString();
            liste.next();
        }
        
        
        return string;
    }

    public int getNr() 
    {
        return nr + 1;
    }
    
}
