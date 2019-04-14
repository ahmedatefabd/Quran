package adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.qurankarem.CategoryActivity;
import com.example.qurankarem.R;
import com.example.qurankarem.ayah.AyahActivity;
import model.Surah;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahHolder> {
    private Context mContext;
    private List<Surah> surahList;

    public SurahAdapter(Context mContext, List<Surah> surahList1) {
        this.mContext = mContext;
        this.surahList = surahList1;
    }

    @Override
    public SurahHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_surah, parent, false);
        SurahHolder holder = new SurahHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SurahHolder holder, int position) {

        final Surah surah = surahList.get(position);

//        holder.surah_Number.setText(String.valueOf(surah.getNumber()));
//        holder.surah_english.setText(surah.getEnglishName());
        holder.surah_arabic.setText(surah.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AyahActivity.class);
                intent.putExtra("surah", surah);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public class SurahHolder extends RecyclerView.ViewHolder {
        public TextView surah_Number;
        public TextView surah_english;
        public TextView surah_arabic;

        public SurahHolder(View view) {
            super(view);
//            this.surah_Number = view.findViewById(R.id.surah_Number);
//            this.surah_english = view.findViewById(R.id.surah_english);
            this.surah_arabic = view.findViewById(R.id.surah_arabic);
        }
    }
}