/*
 * Copyright (c) 2005 Aetrion LLC.
 */
package com.googlecode.flickrjandroid.photosets;

import java.io.Serializable;

import java.util.Date;
import com.googlecode.flickrjandroid.people.User;
import com.googlecode.flickrjandroid.photos.Photo;
import com.googlecode.flickrjandroid.photos.PhotoList;

/**
 * Meta information about a photoset.  To retrieve the photos in the photoset use PhotosetsInterface.getPhotos().
 *
 * @author Anthony Eden
 * @version $Id: Photoset.java,v 1.7 2009/07/12 22:43:07 x-mago Exp $
 */
public class Photoset implements Serializable {
    private static final long serialVersionUID = 12L;

    private String id;
    private String url;
    private User owner;
    private Photo primaryPhoto;
    private String secret;
    private String server;
    private String farm;
    private int photoCount;
    private String title;
    private String description;
    private PhotoList photoList;
    private Date lastUpdate;

    public Photoset() {
    	super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        if(url == null) {
            StringBuffer sb = new StringBuffer();
            sb.append("http://www.flickr.com/photos/");
            sb.append(getOwner().getId());
            sb.append("/sets/");
            sb.append(getId());
            sb.append("/");
            return sb.toString();
        } else {
            return url;
        }
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdateStr) {
        if (lastUpdateStr == null || "".equals(lastUpdateStr)) return;
        long unixTime = Long.parseLong(lastUpdateStr);
        lastUpdate = new Date(unixTime * 1000L);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Photo getPrimaryPhoto() {
        return primaryPhoto;
    }

    public void setPrimaryPhoto(Photo primaryPhoto) {
        this.primaryPhoto = primaryPhoto;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public void setPhotoCount(String photoCount) {
        if (photoCount != null) {
            setPhotoCount(Integer.parseInt(photoCount));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	/**
	 * @return the photoList
	 */
	public PhotoList getPhotoList() {
		return photoList;
	}

	/**
	 * @param photoList the photoList to set
	 */
	public void setPhotoList(PhotoList photoList) {
		this.photoList = photoList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photoset other = (Photoset) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
