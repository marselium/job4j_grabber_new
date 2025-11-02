package ru.job4j.grabber.model;

import java.util.Objects;

public class Post {

    /**
     * идентификатор вакансии
     */
    private Long id;

    /**
     * название вакансии
     */
    private String title;

    /**
     * ссылка на описание вакансии
     */
    private String link;

    /**
     * описание вакансии
     */
    private String description;

    /**
     * дата создания вакансии (мс)
     */
    private Long time;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id.equals(post.id) && link.equals(post.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}
