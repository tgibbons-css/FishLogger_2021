package css.fishlogger;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<FishRowViewHolder> {

    FishFirebaseData fishDataSource;

    RecycleViewAdapter (FishFirebaseData fishDataSource) {
        this.fishDataSource = fishDataSource;
    }

    @NonNull
    @Override
    public FishRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fish_row_layout, parent, false);
        FishRowViewHolder holder = new FishRowViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FishRowViewHolder holder, int position) {
        Fish fish = fishDataSource.getFish(position);
        Log.d("CIS 3334", "RecycleViewAdapter: Display fish of "+fish);
        String species = fish.getSpecies();
        holder.textViewSpecies.setText(species);
        holder.textViewWeight.setText(fish.getWeightInOz());
        holder.textViewDate.setText(fish.getDateCaught());

        if (species.toLowerCase().contains("bass")) {
            holder.imageViewFishIcon.setImageResource(R.drawable.largemouth);
        } else if (species.toLowerCase().contains("walleye")) {
            holder.imageViewFishIcon.setImageResource(R.drawable.walleye);
        } else if (species.toLowerCase().contains("northern")) {
            holder.imageViewFishIcon.setImageResource(R.drawable.northern);
        } else {
            holder.imageViewFishIcon.setImageResource(R.drawable.fish);
        }
    }

    @Override
    public int getItemCount() {
        Log.d("CIS 3334", "RecycleViewAdapter: getItemCount = "+fishDataSource.getNumberOfFish());
        return fishDataSource.getNumberOfFish();
    }
}
