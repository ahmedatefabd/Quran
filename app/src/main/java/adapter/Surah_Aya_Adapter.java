package adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qurankarem.R;
import com.example.qurankarem.ayah.AyahActivity;

import model.Surah_Aya;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class Surah_Aya_Adapter extends RecyclerView.Adapter<Surah_Aya_Adapter.SurahHolder> {
    private Context mContext;
    private List<Surah_Aya> surahAyaList;

    public Surah_Aya_Adapter(Context mContext, List<Surah_Aya> surahAyaList1) {
        this.mContext = mContext;
        this.surahAyaList = surahAyaList1;
    }

    @Override
    public SurahHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_surah, parent, false);
        SurahHolder holder = new SurahHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SurahHolder holder, int position) {

        final Surah_Aya surahAya = surahAyaList.get(position);

//        holder.surah_Number.setText(String.valueOf(surahAya.getNumber()));
//        holder.surah_english.setText(surahAya.getEnglishName());
        holder.surah_arabic.setText(surahAya.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AyahActivity.class);
                intent.putExtra("surahAya", surahAya);
//                Animatoo.animateZoom(mContext);
                mContext.startActivity(intent);

//                mContext.startActivity(new Intent(mContext, HomeActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return surahAyaList.size();
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