package com.rustyapp.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Base entity class that provides common fields for all entities
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class BaseEntity {

    /**
     * Creation timestamp
     */
    private LocalDateTime createdAt;

    /**
     * Last update timestamp
     */
    private LocalDateTime updatedAt;

    /**
     * User who created the record
     */
    private String createdBy;

    /**
     * User who last updated the record
     */
    private String updatedBy;

    /**
     * Soft delete flag
     */
    private Boolean deleted = false;

    /**
     * Version for optimistic locking
     */
    private Long version = 0L;
} 