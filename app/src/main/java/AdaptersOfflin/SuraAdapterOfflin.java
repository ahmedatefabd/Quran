package AdaptersOfflin;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.qurankarem.R;
import java.util.List;
import ModelDB.SuraDB;
import androidx.recyclerview.widget.RecyclerView;
import model.Surah;

public class SuraAdapterOfflin extends RecyclerView.Adapter<SuraAdapterOfflin.SuraOfflinHolder>{


    private Context mContext;
    private List<SuraDB> suraDBList;

    public SuraAdapterOfflin(Context mContext, List<SuraDB> suraDBList1) {
        this.mContext = mContext;
        this.suraDBList = suraDBList1;
    }

    private static SuraAdapterOfflin instance;

    public static SuraAdapterOfflin getInstance(Context context, List<SuraDB> suraDBList) {
        if (instance == null) {
            synchronized (Surah.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new SuraAdapterOfflin(context, suraDBList);
                }
            }
        }
        return instance;
    }

    @Override
    public SuraOfflinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_surah, parent, false);
        SuraOfflinHolder holder = new SuraOfflinHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SuraOfflinHolder holder, int position) {
        final SuraDB suraDB = suraDBList.get(position);

        holder.surah_arabic.setText(suraDB.getName());
    }

    @Override
    public int getItemCount() {
        return suraDBList.size();
    }

    public class SuraOfflinHolder extends RecyclerView.ViewHolder {
        public TextView surah_arabic;

        public SuraOfflinHolder(View itemView) {
            super(itemView);

            this.surah_arabic = itemView.findViewById(R.id.surah_arabic);
        }
    }
}
