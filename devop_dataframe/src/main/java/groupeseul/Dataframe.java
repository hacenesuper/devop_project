package groupeseul;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
/**
* la classe represente un dataframe 
*  
* @author amrane hacene 
* @version 1.0
*/
public class Dataframe {
 
    private List<col> data;
    private ArrayList<String> labels;
    private int nbligne ;
    public int getNbligne() {
        return nbligne;
    }
    /**
     * constructeur set a vide :
     * inisiatise un dataframe vide 
     */
    public Dataframe() {
        data =new ArrayList<col>();
        labels=new ArrayList<String>();
        nbligne=0;

    }
    /**
     * Constructeur à partir de données entrées manuellement
     * @param map : map contenant les données
     */
    @SuppressWarnings("unchecked")
    public Dataframe( HashMap<String, List<?>> map) {
  
    ArrayList<List<?>> columns = new ArrayList<List<?>>(map.values());
    int size = columns.get(0).size();
    
      
    data = new ArrayList<col>();
    labels = new ArrayList<String>();
    for (String colname : map.keySet()) {
        String type = map.get(colname).get(0).getClass().toString();
        type = type.substring(type.lastIndexOf('.') + 1);
        data.add(new col(colname,type,map.get(colname))); 
        labels.add(colname);
    }
    nbligne = size;
    }
 /**
     * Constructeur à partir d'un fichier csv
     * @param nomFichier path vers le fichier csv
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public Dataframe(String nomFichier) throws FileNotFoundException, IOException{
        data= new ArrayList<col>();
        labels = new ArrayList<String>();
        CSVReader csvReader = new CSVReader(new FileReader(nomFichier));
        String[] types = csvReader.readNext();
        String[] labels = csvReader.readNext();
        for(int i =0; i<labels.length; i++) {
            this.data.add(new col(labels[i].trim(),types[i].trim(),new ArrayList()));
            this.labels.add(labels[i].trim());
        }
        List<String[]> lines = csvReader.readAll();
        for (String[] row : lines) 
            for (int i=0; i<row.length;i++) 
                data.get(i).getValues().add(row[i]);
        
        nbligne = data.get(0).getsize();
     
 
}
/**
 * affiche le dataframe entre debut et fin 
 * @param debut la ligne ou comlmence laffichage 
 * @param fin la ligne afficher en dernier 
 * @throws BadArgumentException
 */
protected void afficherdev(int debut, int fin) throws BadArgumentException{
    if(debut < 0 || debut > getNbligne())
        throw new BadArgumentException("debut");
    if(fin < 0 || fin > getNbligne()) 
        throw new BadArgumentException("fin");
    if(debut > fin) 
        throw new BadArgumentException("debut shoud be <= fin");
    
    AsciiTable at = new AsciiTable();
    at.addRule();
    at.addRow(labels);
    for(int i=debut;i<fin;i++){
        at.addRule();
        List<String> row = new ArrayList<String>();
        for(col column : data)
            row.add(column.getValues().get(i).toString());
        at.addRow(row);
    }
    at.addRule();
    at.setTextAlignment(TextAlignment.CENTER);
    at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
    System.out.println(at.render());
    
}


/**
 * la methode affiche le debut du dataframe
 * @param nbline le nombre le ligne a afficher 
 * @throws BadArgumentException
 */
public void afficherDebut(int nbline) throws BadArgumentException {
    if(nbline < 0 || nbline > getNbligne())
        throw new BadArgumentException("number of lines");
    afficherdev(0, nbline);
}
/**
 * la methode affiche la fin  du dataframe
 * @param nbline le nombre de ligne a afficher 
 * @throws BadArgumentException
 */
public void afficherFin(int nbline) throws BadArgumentException {
    if(nbline < 0 || nbline > getNbligne())
        throw new BadArgumentException("number of lines");
   afficherdev(getNbligne()-nbline,getNbligne());
}
/**
 * la methode affiche lintegralité du dataframe
 * @throws BadArgumentException
 */
public void afficher() throws BadArgumentException{
    afficherdev(0,getNbligne());
}


/**
 * la methode donne un daraframe qui contiens les lignes selectioner 
 * @param debut le debut de la ligne a selectioner 
 * @param finla drniere ligne a selectioner 
 * @return
 */
public Dataframe selectLigne(int debut ,int fin ){
    Dataframe dataframe = new Dataframe();
    for(col col : this.data)
            dataframe.insertCol( new col(col.getLabel(), col.getType()) );

        for(int i=debut; i<=fin; i++){
            String[] row = this.getligne(i).toArray(new String[0]);
            dataframe.insertligne(row);(row);
        }
return dataframe;
}
/**
 * la methode selectionne une partie des colonne du dataframe 
 * @param l la liste des labels a selectioner 
 * @return un nouveau dataframe qui contiens les colonne selectioner a partir des labels passer en parametre  
 */
public Dataframe selectCol(ArrayList<String> l){
    Dataframe dataframe = new Dataframe();
    for(String label : l){
        col col = this.getcol(label);
        dataframe.insertCol(col);
    }
    dataframe.nbligne = dataframe.data.get(0).getsize();

return dataframe;
}

/**
 * donne la ligne qui corespond a lindex index
 * @param index lindex de la ligne a retourner 
 * @return une liste des valeur a la ligne index 
 */
public List<String> getligne(int index) {
    ArrayList<String> ligne = new ArrayList<String>();
    for(col col : this.data)
        ligne.add(col.getValues().get(index).toString());
    
    return ligne;}

/**
 * la methode donne la colonne qui a le label label
 * @param label le label de la collone a retourner 
 * @return une colone 
 */
public col getcol(String label)  {

    col col = null;
    for(col col1 : data)
        if(col.getLabel().equals(label))
        col = col1;
        
        return col;
    }
/**
 * ajoute une ligne au tadaframe 
 * @param l la ligne a ajouter au dataframe 
 */
public void insertligne(String[] l) {
        
        for(int i=0; i<this.labels.size(); i++){
            this.data.get(i).add(l[i]);
        }
        this.nbligne++;
            
    }
    public void insertCol(col c) {
       
        data.add(c);
        labels.add(c.getLabel());
    }


    public double sum(String label)  {
      
    }
    public double min(String label) {
       
    }
    public double max(String label) {
      
    }
    public double mean(String label) {
        
    }
}
