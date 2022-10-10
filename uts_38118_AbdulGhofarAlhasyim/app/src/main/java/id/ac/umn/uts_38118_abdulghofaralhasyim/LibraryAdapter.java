package id.ac.umn.uts_38118_abdulghofaralhasyim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {
    private LinkedList<SourceVideo> mListVideo;
    private LayoutInflater mInflater;
    private Context mContext;

    public LibraryAdapter(Context context, LinkedList<SourceVideo> mDaftarSfx) {
        this.mListVideo = mDaftarSfx;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_cardlist, parent, false);
        return new LibraryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SourceVideo mSumberSfx = mListVideo.get(position);
        holder.tvTitle.setText(mSumberSfx.getTitle());
        holder.btnDelete.setOnClickListener(v -> {
//            HOW TO OPEN DIALOG ON RECYCLE VIEW ? HMMMMMMMMM
                mListVideo.remove(position);
                notifyItemRemoved(position);
        });
    }


    @Override
    public int getItemCount() {
        return mListVideo.size();
    }
    public class LibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvTitle, tvDesc;
        private ImageButton btnDelete;
        private SourceVideo mSourceVideo;
        private int mPosisi;
        private LibraryAdapter mAdapter;
        public LibraryViewHolder(@NonNull View itemView, LibraryAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSourceVideo = mListVideo.get(mPosisi);
            Intent detailIntent = new Intent(mContext, VideoDetail.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("VideoDetail", mSourceVideo);
            detailIntent.putExtras(bundle);
            String videoTitle = tvTitle.getText().toString();
            detailIntent.putExtra("VideoTitle", videoTitle);
            mContext.startActivity(detailIntent);
        }
    }
}

