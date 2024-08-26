package cn.itcast.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdpater extends BaseAdapter {
    String[] contents = new String[]{"5月10日，中共中央总书记、国家主席、中央军委主席习近平在大会上发表重要讲话。",
            "5月10日，习近平、李克强、栗战书、汪洋、王沪宁、赵乐际、韩正等出席大会。",
            "5月10日，中共中央总书记、国家主席、中央军委主席习近平在大会上发表重要讲话。",
            "5月10日，中共中央总书记、国家主席、中央军委主席习近平在大会上发表重要讲话。",
            "5月10日，庆祝中国共产主义青年团成立100周年大会在北京人民大会堂隆重举行。",
            "2021年5月15日，航天科研人员在北京航天飞行控制中心指挥大厅庆祝我国首次火星探测任务着陆火星成功。"};
    int[] imgs = {R.drawable.l1,R.drawable.l2,R.drawable.l3,R.drawable.l4,R.drawable.l5,R.drawable.l6};
    Context mContext;
    public ListAdpater(Context mContext){
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            view = View.inflate(mContext,R.layout.list1,null);
            holder = new ViewHolder();
            holder.item_title = view.findViewById(R.id.title);
            holder.item_img = view.findViewById(R.id.iv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.item_title.setText(contents[i]);
        holder.item_img.setBackgroundResource(imgs[i]);
        return view;
    }
    class ViewHolder {
        TextView item_title;
        ImageView item_img;
    }
}
