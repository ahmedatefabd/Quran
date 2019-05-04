package adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qurankarem.R;
import com.example.qurankarem.readerAudio.ReaderAudio;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import model.Readers;

public class ReaderAdapter extends RecyclerView.Adapter<ReaderAdapter.SurahHolder> {
    private Context mContext;
    private List<Readers> readersList;

    public ReaderAdapter(Context mContext, List<Readers> readersList1) {
        this.mContext = mContext;
        this.readersList = readersList1;
    }

    @Override
    public SurahHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_voice_reader, parent, false);
        SurahHolder holder = new SurahHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SurahHolder holder, int position) {

        final Readers readers = readersList.get(position);
        holder.reader_name.setText(readers.getSora());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReaderAudio.class);
                intent.putExtra("Audio", readers);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return readersList.size();
    }

    public class SurahHolder extends RecyclerView.ViewHolder {
        public TextView surah_Number;
        public TextView surah_english;
        public TextView reader_name;

        public SurahHolder(View view) {
            super(view);
//            this.surah_Number = view.findViewById(R.id.surah_Number);
//            this.surah_english = view.findViewById(R.id.surah_english);
            this.reader_name = view.findViewById(R.id.reader_name);
        }
    }
}