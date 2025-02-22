package com.thoughtbot.expandablerecyclerview.sample;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class Genre extends ExpandableGroup<Artist> {

  private int iconResId;

  private boolean isFetching;

  public Genre(String title, List<Artist> items, int iconResId) {
    super(title, items);
    this.iconResId = iconResId;
  }

  public Genre(String title, List<Artist> items, int iconResId, boolean isFetching) {
    super(title, items);
    this.isFetching = isFetching;
    this.iconResId = iconResId;
  }

  public boolean isFetching() {
    return isFetching;
  }

  public void setFetching(boolean fetching) {
    isFetching = fetching;
  }

  public int getIconResId() {
    return iconResId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Genre)) return false;

    Genre genre = (Genre) o;

    return getIconResId() == genre.getIconResId();

  }

  @Override
  public int hashCode() {
    return getIconResId();
  }
}

