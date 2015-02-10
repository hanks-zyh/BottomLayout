package comzyh.bottomlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 主界面底部的按钮切换布局
 * 
 * @version 1.0
 * @author zyh
 */
public class BottomLayout extends LinearLayout implements OnClickListener {

    public BottomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BottomLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomLayout(Context context) {
        this(context, null, 0);
    }

    private Context context;
    private View rl_home, rl_encounter, rl_community, rl_message, rl_user;
    private View iv_new_message, iv_new_home;
    private Button btn_home, btn_encounter, btn_community, btn_message, btn_user;
    private OnItemClickListener listener;
    private int currentPosition = 0;

    /**
     * 初始化
     * 
     * @version 1.0
     * @author zyh
     * @param context
     */
    private void init(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_bottom, this);
        // 5块等分的布局
        rl_home = findViewById(R.id.rl_home);
        rl_encounter = findViewById(R.id.rl_encounter);
        rl_community = findViewById(R.id.rl_community);
        rl_message = findViewById(R.id.rl_message);
        rl_user = findViewById(R.id.rl_user);

        // 5个按钮
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_encounter = (Button) findViewById(R.id.btn_encounter);
        btn_community = (Button) findViewById(R.id.btn_community);
        btn_message = (Button) findViewById(R.id.btn_message);
        btn_user = (Button) findViewById(R.id.btn_user);

        // 小圆点
        iv_new_home = findViewById(R.id.iv_new_home);
        iv_new_message = findViewById(R.id.iv_new_message);

        hideHomeCircle();
        hideMessageCircle();
        changeButtonStatus(0);// 默认是位置0
        setListener();
    }

    /**
     * 显示首页按钮旁边的小红圈
     * 
     * @version 1.0
     * @author zyh
     */
    public void showHomeCircle() {
        iv_new_home.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏首页按钮旁边的小红圈
     * 
     * @version 1.0
     * @author zyh
     */
    public void hideHomeCircle() {
        iv_new_home.setVisibility(View.GONE);
    }

    /**
     * 显示首页按钮旁边的小红圈
     * 
     * @version 1.0
     * @author zyh
     */
    public void showMessageCircle() {
        iv_new_message.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏首页按钮旁边的小红圈
     * 
     * @version 1.0
     * @author zyh
     */
    public void hideMessageCircle() {
        iv_new_message.setVisibility(View.GONE);
    }

    /**
     * 为按钮设计按下监听
     * 
     * @version 1.0
     * @author zyh
     */
    private void setListener() {
        rl_home.setOnClickListener(this);
        rl_encounter.setOnClickListener(this);
        rl_community.setOnClickListener(this);
        rl_message.setOnClickListener(this);
        rl_user.setOnClickListener(this);
    }

    /**
     * 提供给外部设置点击Item的接口
     * 
     * @version 1.0
     * @author zyh
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    @Override
    public void onClick(View v) {
        currentPosition = 0;
        switch (v.getId()) {
            case R.id.rl_home:
                currentPosition = 0;
                break;
            case R.id.rl_encounter:
                currentPosition = 1;
                break;
            case R.id.rl_community:
                currentPosition = 2;
                break;
            case R.id.rl_message:
                currentPosition = 3;
                break;
            case R.id.rl_user:
                currentPosition = 4;
                break;
        }
        if (listener == null) {
            return;
        }
        listener.onItemClick(currentPosition);
        changeButtonStatus(currentPosition);
    }

    /**
     * 根据当前位置改变按钮选中状态
     * 
     * @version 1.0
     * @author zyh
     * @param position
     */
    private void changeButtonStatus(int position) {
        btn_home.setSelected(position == 0);
        btn_encounter.setSelected(position == 1);
        btn_community.setSelected(position == 2);
        btn_message.setSelected(position == 3);
        btn_user.setSelected(position == 4);
    }
}
