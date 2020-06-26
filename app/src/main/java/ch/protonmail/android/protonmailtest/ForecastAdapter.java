package ch.protonmail.android.protonmailtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ProtonMail on 2/25/19.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.DayViewHolder> {

    private String[] data;

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, null, false);
        return new DayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.titleView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public void updateData(String[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public static class DayViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;
        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
        }
    }
}
