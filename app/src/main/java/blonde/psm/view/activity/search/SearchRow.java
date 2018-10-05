package blonde.psm.view.activity.search;

import blonde.psm.R;

public class SearchRow {

    private int titleImage;
    private String titleName;

    public SearchRow(int titleImage, String titleName) {

        //this.titleImage = titleImage;
        this.titleName = titleName;

        // FIXME
        this.titleImage = R.raw.baseline_broken_image_black_18dp;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public String getTitleName() {
        return titleName;
    }
}
