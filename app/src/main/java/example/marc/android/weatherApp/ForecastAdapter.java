package example.marc.android.weatherApp;

import WeatheList.WeatherListItemUiModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.DayViewHolder> {

    private List<WeatherListItemUiModel> data = new ArrayList<>();
    private OnItemClickedListener onItemClickedListener = null;

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, null, false);
        return new DayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, final int position) {
        holder.titleView.setText(data.get(position).getTitle());
        holder.imageView.setUrl(data.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickedListener != null) {
                    onItemClickedListener.onItemClicked(position);
                }
            }
        });
        holder.maxTemperatureView.setText(data.get(position).getMaxTemperature());
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
        private TextView maxTemperatureView;
        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
            maxTemperatureView = itemView.findViewById(R.id.max_temperature_text);
        }
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    interface OnItemClickedListener {
        void onItemClicked(int positionInTheList);
    }
}
