package adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.qurankarem.R;
import model.Ayah;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class AyahAdapter  extends RecyclerView.Adapter<AyahAdapter.AyahHolder> {
    private Context mContext;
    private List<Ayah> ayahList;

    public AyahAdapter(Context mContext, List<Ayah> ayahs) {
        this.mContext = mContext;
        this.ayahList = ayahs;
    }

    @Override
    public AyahHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_ayah, parent, false);
        AyahHolder holder = new AyahHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(AyahHolder holder, int position) {

        final Ayah ayah = ayahList.get(position);

        holder.ayah_Name.setText(String.valueOf(ayah.getText()));
        holder.numberAyah.setText(String.valueOf(ayah.getNumberInSurah()));

    }

    @Override
    public int getItemCount() {
        return ayahList.size();
    }

    public class AyahHolder extends RecyclerView.ViewHolder {
        public TextView ayah_Name;
        public TextView numberAyah;

        public AyahHolder(View view) {
            super(view);
            this.ayah_Name = view.findViewById(R.id.name_textView);
            this.numberAyah = view.findViewById(R.id.number_ayah);
        }
    }
}
