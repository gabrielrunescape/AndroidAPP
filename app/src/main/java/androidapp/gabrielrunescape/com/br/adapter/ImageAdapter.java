package androidapp.gabrielrunescape.com.br.adapter;

import java.util.*;
import android.view.*;
import android.widget.*;
import android.content.Context;
import androidapp.gabrielrunescape.com.br.R;

/**
 *      Criado por GabrielRuneScape <gabrielfilipe@mail.ru> em 02/11/2016.
 *
 *      Classe adaptadora responsável pelo activity_main.xml e por item_main.xml em relação ao seu
 * design e layout.
 *
 *      Arquivo original obtivo em:
 *      https://developer.android.com/guide/topics/ui/layout/gridview.html, acesso em 2 nov de 2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Choose> itens = new ArrayList<>();

    public ImageAdapter(Context c) {
        mContext = c;
        String[] s = c.getResources().getStringArray(R.array.sample_main);

        itens.add(new Choose(R.drawable.sample_1, s[0]));
        itens.add(new Choose(R.drawable.sample_2, s[1]));
        itens.add(new Choose(R.drawable.sample_3, s[2]));
        itens.add(new Choose(R.drawable.sample_4, s[3]));
        itens.add(new Choose(R.drawable.sample_5, s[4]));
        itens.add(new Choose(R.drawable.sample_6, s[5]));
    }

    public int getCount() {
        return itens.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_main, null);
        }

        final ImageView image = (ImageView) convertView.findViewById(R.id.imageChoose);
        final TextView label = (TextView) convertView.findViewById(R.id.labelChoose);

        convertView.setPadding(14, 14, 14, 14);

        image.setImageResource(itens.get(position).getIcon());
        label.setText(itens.get(position).getDesc());

        return convertView;
    }
}

class Choose {
    private Integer icon;
    private String desc;

    public Choose(Integer icon, String desc) {
        this.desc = desc;
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getIcon() {
        return icon;
    }
}
