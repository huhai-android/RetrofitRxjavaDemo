package com.example.huhai.retrofitrxjavademo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.huhai.retrofitrxjavademo.R;
import com.example.huhai.retrofitrxjavademo.bean.blogUrl;
import com.example.huhai.retrofitrxjavademo.greendao.blogUrlDao;
import com.example.huhai.retrofitrxjavademo.manager.Dbhelper;

import java.util.List;

/*
 *  @项目名：  RetrofitRxjavaDemo
 *  @包名：    com.example.huhai.retrofitrxjavademo.adapter
 *  @文件名:   MyAdapter
 *  @创建者:   huhai
 *  @创建时间:  2018/11/14 11:32
 *  @描述：
 */
public class MyAdapter extends BaseAdapter {
    private final List<blogUrl> data;
    private Context mContext;
    public MyAdapter(List<blogUrl> data, Context context) {
    this.data=data;
    mContext=context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (holder==null){
            holder=new ViewHolder();
            convertView=View.inflate(mContext, R.layout.item_listurl,null);
            holder.text= convertView.findViewById(R.id.tv_text);
            holder.delete= convertView.findViewById(R.id.btn_delete);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text.setText(data.get(position).getName());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除数据

                List<blogUrl> findUser = Dbhelper.getDaoSession().getBlogUrlDao().queryBuilder().where(blogUrlDao.Properties.Name.eq(data.get(position).getName())).build().list();
                if(findUser != null){
                    for (int i = 0; i <findUser.size() ; i++) {
                        Dbhelper.getDaoSession().getBlogUrlDao().delete(findUser.get(i));
                        data.remove(position);
                    }
                }

                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView text;
        Button delete;
    }

    public void setdata(List<blogUrl> dataurl) {
        data.clear();
        data.addAll(dataurl);
        notifyDataSetChanged();
    }
}
