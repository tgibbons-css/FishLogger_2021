package css.fishlogger;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FishRowViewHolder extends RecyclerView.ViewHolder{
    TextView textViewSpecies;
    TextView textViewWeight;
    TextView textViewDate;
    ImageView imageViewFishIcon;

    public FishRowViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewSpecies = itemView.findViewById(R.id.textViewSpecies);
        textViewWeight = itemView.findViewById(R.id.textViewWeight);
        textViewDate = itemView.findViewById(R.id.textViewDate);
        imageViewFishIcon = itemView.findViewById(R.id.imageViewFish);
    }
}
