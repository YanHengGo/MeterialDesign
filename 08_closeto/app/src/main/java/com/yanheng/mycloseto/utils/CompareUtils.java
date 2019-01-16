package com.yanheng.mycloseto.utils;

import com.liuguilin.closeto.model.FileBrowseModel;

import java.util.Comparator;

/**
 * ProjectName: CloseTo
 * PackageName: com.liuguilin.closeto.utils
 * User:        LiuGuiLinAndroid
 * Email:       lgl@szokl.com.cn
 * Date:        2017/11/19 22:19
 * Desc:        排序
 */

public class CompareUtils implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        FileBrowseModel model1 = (FileBrowseModel) o1;
        FileBrowseModel model2 = (FileBrowseModel) o2;
        //标准的 0-9 A-Z
        return model1.getTitle().compareTo(model2.getTitle());
    }
}
