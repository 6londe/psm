package blonde.psm.view.activity.search;

import blonde.psm.R;

public class SearchRow {

    private int titleImage;
    private String titleName;

    public SearchRow(int titleImage, String titleName) {

        // FIXME
        //this.titleImage = titleImage;
        this.titleImage = R.drawable.ic_broken_image_black_24dp;

        this.titleName = titleName;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public String getTitleName() {
        return titleName;
    }
}
