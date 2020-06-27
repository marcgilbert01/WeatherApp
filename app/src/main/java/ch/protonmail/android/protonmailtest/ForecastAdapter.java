package ch.protonmail.android.protonmailtest;

import WeatheList.WeatherListItemUiModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProtonMail on 2/25/19.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.DayViewHolder> {

    private List<WeatherListItemUiModel> data = new ArrayList<>();

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, null, false);
        return new DayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.titleView.setText(data.get(position).getTitle());
        holder.imageView.setUrl(data.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<WeatherListItemUiModel> weatherListItemUiModelList) {
        this.data = weatherListItemUiModelList;
        notifyDataSetChanged();
    }

    public static class DayViewHolder extends RecyclerView.ViewHolder {

        private TextView titleView;
        private CustomImageView imageView;
        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
