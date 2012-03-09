package br.com.copa;

import java.util.List;

import br.com.copa.Model.Time;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeAdapter extends BaseAdapter{
	private List<Time> listTimes;
	 
    //Classe utilizada para instanciar os objetos do XML
    private LayoutInflater inflater;
     
    public TimeAdapter(Context context, List<Time> plistTimes) {
        this.listTimes = plistTimes;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	public int getCount() {
		// TODO Auto-generated method stub
		return listTimes.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listTimes.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		///Pega o registro da lista e trasnfere para o objeto TimeVO
        Time time = listTimes.get(position);
         
        //Utiliza o XML Time_row para apresentar na tela
        convertView = inflater.inflate(R.layout.time_list, null);
         
        //Inst�ncia os objetos do XML
        ImageView bandeira = (ImageView)convertView.findViewById(R.id.bandeira);
        TextView tvTime = (TextView)convertView.findViewById(R.id.nomeTime);
       
             
        //pega os dados que est�o no objeto TimeVO e transfere para os objetos do XML
        bandeira.setImageResource(time.getBandeira());
        tvTime.setText(time.getNome());
        
         
        return convertView;
	}
 
   
}
