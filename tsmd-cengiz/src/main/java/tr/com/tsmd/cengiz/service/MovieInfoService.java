package tr.com.tsmd.cengiz.service;

import tr.com.tsmd.cengiz.models.CatalogItem;
import tr.com.tsmd.cengiz.models.Rating;

public interface MovieInfoService {
  public CatalogItem getCatalogItem(Rating rating);
}
